package com.gyx.leetcode.list1_50;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        int nowNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nowNum != nums[i]) {
                nums[count] = nowNum = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i = removeDuplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(i);
    }
}
