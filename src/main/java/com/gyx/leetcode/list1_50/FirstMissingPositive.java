package com.gyx.leetcode.list1_50;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int min = 1;
        int last = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && last != nums[i]) {
                if (min < nums[i]) {
                    return min;
                } else {
                    min++;
                }
                last = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int i = firstMissingPositive.firstMissingPositive(new int[]{1, 1});
        System.out.println(i);
    }
}
