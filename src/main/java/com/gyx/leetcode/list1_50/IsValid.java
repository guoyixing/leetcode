package com.gyx.leetcode.list1_50;

import java.util.*;

public class IsValid {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> brackets = new HashMap<>(3);
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (brackets.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.empty() || !brackets.get(stack.pop()).equals(aChar)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        boolean valid = isValid.isValid("()");
        System.out.println(valid);
    }
}
