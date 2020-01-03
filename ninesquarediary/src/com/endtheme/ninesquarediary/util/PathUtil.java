package com.endtheme.ninesquarediary.util;

import com.endtheme.ninesquarediary.AppContext;

public class PathUtil {

    public static String getFullPath(String path) {
        if (path == null) {
            path = "";
        }
        String urlPrefix = "page";
        if (!StringUtil.isEmpty(urlPrefix)) {
            urlPrefix += "/";
        }

        return AppContext.getContextPath() + "/" + urlPrefix  + path;
    }

}
