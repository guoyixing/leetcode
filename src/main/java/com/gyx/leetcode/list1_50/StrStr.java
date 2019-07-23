package com.gyx.leetcode.list1_50;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        for (int i = 0; i < haystackChars.length - needleChars.length + 1; i++) {
            //比较字符串
            if (strEqual(haystackChars, needleChars, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean strEqual(char[] haystackChars, char[] needleChars, int i) {
        for (int j = 0; j < needleChars.length; j++) {
            if (haystackChars[i + j] != needleChars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int i = strStr.strStr("aipi", "pi");
        System.out.println(i);
    }
}
