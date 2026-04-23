package com.leetcode;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }
        if (totalSum == minSum) {
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }


    public static void main(String[] args) {
        MaximumSumCircularSubarray task = new MaximumSumCircularSubarray();
        System.out.println(task.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(task.maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(task.maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }
}
