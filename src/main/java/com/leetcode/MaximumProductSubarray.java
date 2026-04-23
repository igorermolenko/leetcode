package com.leetcode;

public class MaximumProductSubarray {

    // =========================================
    // Kadane's Algorithm       --- O(n)
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int temp1 = currentMax * current;
            int temp2 = currentMin * current;
            currentMax = Math.max(current, Math.max(temp1, temp2));
            currentMin = Math.min(current, Math.min(temp1, temp2));
            result = Math.max(result, currentMax);
        }

        return result;
    }


    public static void main(String[] args) {
        MaximumProductSubarray task = new MaximumProductSubarray();
        System.out.println(task.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(task.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(task.maxProduct(new int[]{-3, -1, -1}));
        System.out.println(task.maxProduct(new int[]{7, -2, -4}));
        System.out.println(task.maxProduct(new int[]{-3, 0, 1, -2}));
        System.out.println(task.maxProduct(new int[]{7, -2, 5, -4}));
        System.out.println(task.maxProduct(new int[]{2, -5, -2, -4, 3}));
    }
}
