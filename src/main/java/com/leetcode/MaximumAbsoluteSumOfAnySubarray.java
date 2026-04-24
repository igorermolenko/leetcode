package com.leetcode;

public class MaximumAbsoluteSumOfAnySubarray {

    // =========================================
    // Kadane's Algorithm       --- O(n)
    public int maxAbsoluteSum(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMin = Math.min(currentMin + num, num);
            globalMax = Math.max(globalMax, currentMax);
            globalMin = Math.min(globalMin, currentMin);
        }

        return Math.max(Math.abs(globalMax), Math.abs(globalMin));
    }


    public static void main(String[] args) {
        MaximumAbsoluteSumOfAnySubarray task = new MaximumAbsoluteSumOfAnySubarray();
        System.out.println(task.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
        System.out.println(task.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
        System.out.println(task.maxAbsoluteSum(new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}));
    }
}
