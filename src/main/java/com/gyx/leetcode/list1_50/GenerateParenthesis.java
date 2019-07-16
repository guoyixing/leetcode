package com.gyx.leetcode.list1_50;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        if (n == 1) {
            list.add("()");
            return list;
        }

        creatBracket(list, "", 0, 0, n);
        return list;
    }

    private void creatBracket(List<String> list, String bracket, int left, int right, int n) {
        if (bracket.length() == n * 2) {
            list.add(bracket);
            return;
        }
        if (left < n) {
            creatBracket(list, bracket + "(", left + 1, right, n);
        }
        if (right < left) {
            creatBracket(list, bracket + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        System.out.println(list);
    }
}
