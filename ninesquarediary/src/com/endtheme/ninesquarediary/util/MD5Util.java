package com.endtheme.ninesquarediary.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

    private static String md5 = "MD5";

    /**
     * Encrypt string MD5 (lower case + letter)
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {

        try {
            MessageDigest md = MessageDigest.getInstance(md5);
            md.update(str.getBytes());

            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();

           return null;
        }
    }


    /**
     * Encrypt string MD5 (upper case + number)
     *
     * @param str Pass in string to encrypt
     * @return MD5 encrypted string
     */
    public static String MD5(String str) {

        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if (StringUtil.isEmpty(str)) {
            return str;
        }

        str = str + "online..."; // add salt
        try {
            byte[] btInput = str.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance(md5);
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char strs[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                strs[k++] = hexDigits[byte0 >>> 4 & 0xf];
                strs[k++] = hexDigits[byte0 & 0xf];
            }

            return new String(strs);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
