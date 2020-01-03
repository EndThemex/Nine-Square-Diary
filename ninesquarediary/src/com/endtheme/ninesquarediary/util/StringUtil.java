package com.endtheme.ninesquarediary.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {

    public static boolean isEmpty(String data) {
        boolean flag = false;
        if (data == null || "".equals(data)) {
            flag = true;
        }

        return flag;
    }

    /**
     * Escape special characters.
     * @param data Special character statements that need to be escaped.
     * @return Special characters after escape.
     */
    public static String escapeCharacter(String data) {
        if (!isEmpty(data)) {
        	// TODO < > 
            data = data.trim();
        }

        return data;
    }

    public static boolean isNumeric(String str){
        boolean flag = true;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if(!isNum.matches()){
            flag = false;
        }

        return flag;
    }

}
