package com.gyx.leetcode.list1_50;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            List<Character> list = new ArrayList<>();
            list.add(chars[i]);
            for (int j = i+1; j < chars.length; j++) {
                if (!list.contains(chars[j])){
                    list.add(chars[j]);
                }else {
                    break;
                }
            }
            lists.add(list);
        }

        int maxNum = 0;
        for (List<Character> list : lists) {
            maxNum=maxNum>list.size()?maxNum:list.size();
        }
        return maxNum;
    }
}
