package com.gyx.leetcode.list1_50;

public class MaxArea {
    public int maxArea(int[] height) {
        int leftEdgeHight;
        int rightEdgeHight;
        int leftEdge = 0;
        int rightEdge = height.length - 1;
        int width = height.length - 1;
        int maxVolume = 0;

        if (height.length == 2L) {
            return height[0] < height[1] ? height[0] : height[1] * width;
        }

        for (; leftEdge <= rightEdge; ) {
            leftEdgeHight=height[leftEdge];
            rightEdgeHight=height[rightEdge];
            int volume = (leftEdgeHight <= rightEdgeHight ? leftEdgeHight : rightEdgeHight) * width;
            maxVolume = maxVolume >= volume ? maxVolume : volume;
            if (leftEdgeHight <= rightEdgeHight){
                leftEdge++;
            }else {
                rightEdge--;
            }
            width--;
        }
        return maxVolume;
    }
}
