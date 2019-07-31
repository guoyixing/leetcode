package com.gyx.leetcode.list1_50;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        for (int i = left; i < nums.length; i++) {
            if (nums[left] == nums[i]) {
                right = i;
            }
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        SearchRange search = new SearchRange();
        int[] ints = search.searchRange(new int[]{1, 2, 2}, 1);
        System.out.println(ints);
    }
}
