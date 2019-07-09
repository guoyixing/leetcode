package com.gyx.leetcode.list1_50;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums3 = new int[length1 + length2];
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while (num1 < length1 && num2 < length2) {
            nums3[num3++] = nums1[num1] < nums2[num2] ? nums1[num1++] : nums2[num2++];
        }
        // 把左边剩余的数移入数组
        while (num1 < length1) {
            nums3[num3++] = nums1[num1++];
        }
        // 把右边边剩余的数移入数组
        while (num2 < length2) {
            nums3[num3++] = nums2[num2++];
        }
        if (num3 % 2 == 0) {
            int i = (num3 - 1) / 2;
            double i1 = nums3[i];
            double i2 = nums3[i + 1];
            return (i1 + i2) / 2;
        } else {
            return nums3[(num3 - 1) / 2];
        }
    }
}
