package com.gyx.leetcode.list1_50;

public class RomanToInt {
    public int romanToInt(String s) {
        String[] strings = new String[]{"CM", "M", "CD", "D", "XC", "C", "XL", "L", "IX", "X", "IV", "V", "I"};
        int[] nums = new int[]{900, 1000, 400, 500, 90, 100, 40, 50, 9, 10, 4, 5, 1};
        int sign = 0;
        int num = 0;
        while (s.length()>0) {
            int oldLength = s.length();
            s = s.replace(strings[sign],"");
            int newLength = s.length();
            if (oldLength == newLength){
                sign++;
                continue;
            }

            num += (oldLength-newLength-strings[sign].length()+1) * nums[sign];
        }
        return num;
    }
}
