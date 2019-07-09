package com.gyx.leetcode.list1_50;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuffer sb = new StringBuffer();
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || !(strs[j].charAt(i) == chars[i])) {
                    flag = false;
                }
            }
            if (flag) {
                sb.append(chars[i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
