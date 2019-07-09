package com.gyx.leetcode.list1_50;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        return validation(chars, 0, chars.length - 1);
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
