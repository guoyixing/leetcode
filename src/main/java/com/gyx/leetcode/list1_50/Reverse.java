package com.gyx.leetcode.list1_50;

public class Reverse {
    public int reverse(int x) {
        long xl = x;
        boolean flag = false;
        if (xl < 0) {
            flag = true;
            xl = 0 - xl;
        }
        String xls = String.valueOf(xl);
        xl = fanzhuan(xls);
        if (xl> Integer.MIN_VALUE && xl < Integer.MAX_VALUE){
            if (flag){
                return (int)-xl;
            }else {
                return (int)xl;
            }

        }
        return 0;
    }

    private long fanzhuan(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1 ; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return Long.parseLong(sb.toString());
    }
}
