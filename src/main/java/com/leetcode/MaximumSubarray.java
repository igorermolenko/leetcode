package com.leetcode;

public class MaximumSubarray {

    public double findMaxAverage2(int[] nums, int k) {
        if (nums.length <= k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return (double) sum / nums.length;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }


    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(subarray.findMaxAverage(new int[]{5}, 1));
        System.out.println(subarray.findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
    }
}
