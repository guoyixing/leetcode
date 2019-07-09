package com.gyx.leetcode.list1_50;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtoi {
    public int myAtoi(String str) {
        String trim = str.trim();
        Pattern compile = Pattern.compile("^([\\+|\\-]?\\d+)");
        Matcher matcher = compile.matcher(trim);
        while(matcher.find()){
            BigInteger bigInteger = new BigInteger(matcher.group(0));
            if (bigInteger.compareTo(new BigInteger("2147483647")) == 1){
                return Integer.MAX_VALUE;
            }else if(bigInteger.compareTo(new BigInteger("-2147483648")) == -1){
                return Integer.MIN_VALUE;
            }else {
                return bigInteger.intValue();
            }
        }
        return 0;
    }
}
