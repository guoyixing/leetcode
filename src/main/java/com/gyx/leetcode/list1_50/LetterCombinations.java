package com.gyx.leetcode.list1_50;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        char[][] chars = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        int[] indexs = new int[digits.length()];
        int[] indexsMaxNum = new int[digits.length()];
        int[] digitsInts = new int[digits.length()];
        char[] digitsChars = digits.toCharArray();
        for (int i = 0; i < digitsChars.length; i++) {
            indexs[i] = 0;
            digitsInts[i] = (int) digitsChars[i] - 50;
            indexsMaxNum[i] = chars[digitsInts[i]].length - 1;
        }

        List<String> result = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            result.add(createStr(chars, indexs, digitsInts));
            flag = indexLevelUp(indexs, indexsMaxNum, digits.length() - 1);
        }
        return result;
    }

    private String createStr(char[][] chars, int[] indexs, int[] digitsInts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digitsInts.length; i++) {
            sb.append(chars[digitsInts[i]][indexs[i]]);
        }
        return sb.toString();
    }

    private boolean indexLevelUp(int[] indexs, int[] indexsMaxNum, int level) {
        if (level < 0) {
            return false;
        }
        int index = ++indexs[level];
        if (index <= indexsMaxNum[level]) {
            indexs[level] = index;
            return true;
        } else {
            indexs[level] = 0;
            return indexLevelUp(indexs, indexsMaxNum, --level);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(strings);
    }
}
