package com.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum = Math.max(sum + num, num);
            if (sum > result) {
                result = sum;
            }
        }

        return  result;
    }


    public static void main(String[] args) {
        MaximumSubarray task = new MaximumSubarray();
        System.out.println(task.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(task.maxSubArray(new int[]{1}));
        System.out.println(task.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
