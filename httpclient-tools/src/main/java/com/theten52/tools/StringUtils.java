package com.theten52.tools;

public class StringUtils {
    public static boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        }

        if (str.length() == 0) {
            return false;
        }

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar != ' ') {
                return true;
            }
        }

        return false;
    }
}
