package com.gyx.leetcode.list1_50;

public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int trap1 = trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap1);
    }
}
