package com.gyx.leetcode.list1_50;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int i = searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(i);
    }
}
