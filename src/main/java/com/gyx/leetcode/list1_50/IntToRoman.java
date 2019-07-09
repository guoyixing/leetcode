package com.gyx.leetcode.list1_50;

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[][] roman = {{'M',' ','C'},
                {'C','D','X'},
                {'X','L','I'},
                {'I','V','I'}};
        char[] chars = String.valueOf(num).toCharArray();
        int[] numArray = new int[4];
        for(int i=0,j=4;i < 4;i++,j--){
            if (chars.length < j){
                numArray[i] = 0;
                continue;
            }
            numArray[i] = chars[chars.length-j]-48;
        }

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == 0){
                continue;
            }
            switch (numArray[i]){
                case 9 :sb.append(roman[i-1][2]).append(roman[i-1][0]);break;
                case 8 :sb.append(roman[i][1]).append(roman[i][0]).append(roman[i][0]).append(roman[i][0]);break;
                case 7 :sb.append(roman[i][1]).append(roman[i][0]).append(roman[i][0]);break;
                case 6 :sb.append(roman[i][1]).append(roman[i][0]);break;
                case 5 :sb.append(roman[i][1]);break;
                case 4 :sb.append(roman[i][0]).append(roman[i][1]);break;
                case 3 :sb.append(roman[i][0]).append(roman[i][0]).append(roman[i][0]);break;
                case 2 :sb.append(roman[i][0]).append(roman[i][0]);break;
                case 1 :sb.append(roman[i][0]);break;
                default:break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        String s = intToRoman.intToRoman(40);
        System.out.println(s);
    }
}
