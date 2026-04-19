package com.leetcode;

public class MaximumSubarray {

    // =========================================
    // Kadane's Algorithm       --- O(n)
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


    // =========================================
    // Divide and Conquer        --- O(n * log(n))
    public int maxSubArray2(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int middle = low + (high - low) / 2;
        int left = maxSubArray(nums, low, middle);
        int right = maxSubArray(nums, middle + 1, high);
        int crossing = crossingMax(nums, low, high, middle);
        return Math.max(crossing, Math.max(left, right));
    }

    private int crossingMax(int[] nums, int low, int high, int middle) {
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = middle; i >= low; i--) {
            sum += nums[i];
            maxLeft = Math.max(maxLeft, sum);
        }
        sum = 0;
        for (int i = middle + 1; i <= high; i++) {
            sum += nums[i];
            maxRight = Math.max(maxRight, sum);
        }
        return maxLeft + maxRight;
    }


    public static void main(String[] args) {
        MaximumSubarray task = new MaximumSubarray();
        System.out.println(task.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(task.maxSubArray(new int[]{1}));
        System.out.println(task.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
