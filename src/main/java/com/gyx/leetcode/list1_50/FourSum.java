package com.gyx.leetcode.list1_50;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int noniusL = 0;
                int noniusR = nums.length - 1;
                while (noniusL < noniusR) {
                    while (noniusL == i || noniusL == j) {
                        noniusL++;
                    }
                    while (noniusR == i || noniusR == j) {
                        noniusR--;
                    }

                    if (noniusL >= noniusR) {
                        continue;
                    }

                    int sum = nums[noniusL] + nums[i] + nums[j] + nums[noniusR];
                    if (sum == target) {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[noniusL]);
                        list.add(nums[noniusR]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        Collections.sort(list);
                        set.add(list);
                        noniusR--;
                        noniusL++;
                    } else if (sum > target) {
                        noniusR--;
                    } else {
                        noniusL++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] ints = new int[]{-3, -1, 0, 2, 4, 5};
        List<List<Integer>> lists = fourSum.fourSum(ints, 0);
        System.out.println(lists);
    }
}
