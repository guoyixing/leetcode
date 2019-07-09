package com.gyx.leetcode.list1_50;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //字符串长度
        int size = 0;
        //开始位置
        int begin = 0;
        //结束位置
        int end = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return "";
        }
        if (chars.length == 1) {
            return s;
        }
        //i是字符串开始的位置
        //j是字符串结束的位置
        //逐一寻找回文数
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                //判断当前这个字符串是不是回文数
                Boolean flag = validation(chars, i, j);
                //记录字符串长度
                if (flag && size < j - i) {
                    begin = i;
                    end = j;
                    size = j - i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = begin; i <= end; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private Boolean validation(char[] chars, int begin, int end) {
        while (begin < end) {
            char beginChar = chars[begin];
            char endChar = chars[end];
            if (beginChar != endChar) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
