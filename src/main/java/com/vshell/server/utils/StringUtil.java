package com.vshell.server.utils;

import org.springframework.util.StringUtils;

/**
 * Created by heroshen on 2017/12/3.
 */
public class StringUtil {
    public static String upperCase(String str) {
        String result = null;
        if (!StringUtils.isEmpty(str)) {
            result = str.substring(0, 1).toLowerCase() + str.substring(1);
        }
        return result;
    }
}
