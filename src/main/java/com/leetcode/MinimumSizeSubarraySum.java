package com.leetcode;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, minLen = Integer.MAX_VALUE;

        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum task = new MinimumSizeSubarraySum();
        System.out.println(task.minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
        System.out.println(task.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(task.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(task.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
