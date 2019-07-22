package com.gyx.leetcode.list1_50;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                --length;
                for (int k = i, j = i + 1; j < nums.length; k++, j++) {
                    nums[k] = nums[j];
                }
                --i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int num = removeElement.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(num);
    }
}
