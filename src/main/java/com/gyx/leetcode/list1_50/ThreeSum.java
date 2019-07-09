package com.gyx.leetcode.list1_50;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            int noniusL = i+1;
            int noniusR = nums.length-1;
            while (noniusL<noniusR){
                int sum = nums[noniusL] + nums[i] + nums[noniusR];
                if (sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[noniusL]);
                    list.add(nums[i]);
                    list.add(nums[noniusR]);
                    set.add(list);
                }
                if(sum > 0) {
                    noniusR--;
                }else if(sum < 0) {
                    noniusL++;
                }else {
                    noniusR--;
                    noniusL++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum.threeSum(ints);
        System.out.println(lists);
    }
}
