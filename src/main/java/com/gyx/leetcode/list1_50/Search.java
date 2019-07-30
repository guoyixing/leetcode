package com.gyx.leetcode.list1_50;

public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int rigth = nums.length - 1;

        while (left<rigth){
            int mid = (left + rigth + 1) / 2;
            if (nums[mid] > nums[left]){
                if (nums[left] == target) {
                    return left;
                }else if (nums[left] < target && target < nums[mid]){
                    rigth = mid - 1;
                }else {
                    left = mid;
                }
            }else {
                if (nums[rigth] == target) {
                    return rigth;
                }else if ( nums[mid] < target && target < nums[rigth]){
                    left = mid;
                }else {
                    rigth = rigth - 1;
                }
            }
        }

        if (nums[left] == target){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int index = search.search(new int[]{5,1,3},3);
//        int index = search.search(new int[]{4,5,6,7,0,1,2},3);
        System.out.println(index);
    }
}
