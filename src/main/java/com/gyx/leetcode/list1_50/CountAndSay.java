package com.gyx.leetcode.list1_50;

public class CountAndSay {
    public String countAndSay(int n) {
        return countHelper("1", n);
    }

    private static String countHelper(String str, int n) {
        if (n == 1){
            return str;
        } else {
            //求下一个数
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            //一直读数
            while (i < str.length()) {
                int count = 1;
                //如果一直是同一个数
                while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                //下一个数更新
                stringBuilder.append(Integer.toString(count) + str.charAt(i));
                i++;
            }
            str = stringBuilder.toString();
        }
        return countHelper(str, n - 1);
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(4);
        System.out.println(s);
    }
}
