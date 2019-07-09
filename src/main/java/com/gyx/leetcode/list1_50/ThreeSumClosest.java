package com.gyx.leetcode.list1_50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int xnum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-1; i++) {
            int noniusL = i+1;
            int noniusR = nums.length-1;
            while (noniusL<noniusR){
                int sum = nums[noniusL] + nums[i] + nums[noniusR];
                if(Math.abs(target - sum) < Math.abs(target - xnum)) {
                    xnum = sum;
                }
                if(sum > target) {
                    noniusR--;
                }else if(sum < target) {
                    noniusL++;
                }else {
                    return xnum;
                }
            }
        }
        return xnum;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] ints = new int[]{-1,2,1,-4};
        int i = threeSumClosest.threeSumClosest(ints,1);
        System.out.println(i);
    }
}
