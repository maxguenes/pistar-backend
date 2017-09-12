package com.pistar.util;

public class XSSUtils {

    public static String stripXSS(String value) {
        if (value != null) {
            value = value.trim().replaceAll("\n", "");
            value = value.replaceAll("\\<.*?>","");
        }
        return value;
    }

}
