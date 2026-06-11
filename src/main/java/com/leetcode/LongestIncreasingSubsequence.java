package com.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // =================================================================
    // O(N^2)
    public int lengthOfLIS2(int[] nums) {
        int dp[] = new int[nums.length];
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, dp[i]);
        }

        return maxCount;
    }

    // =================================================================
    // O(N * logN), but less understandable, better to use previous one
    // Here dp[i] - is tail for sequences with length i, and we continuously minimize this value
    public int lengthOfLIS(int[] nums) {
        int length = 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[length] < nums[i]) {
                dp[++length] = nums[i];
            } else {
                int idx = findIdx(dp, length,nums[i]);
                dp[idx] = nums[i];
            }
        }

        return length + 1;
    }

    private int findIdx(int[] nums, int lastIdx, int value) {
        int left = 0;
        int right = lastIdx;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < value) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence task = new LongestIncreasingSubsequence();
        System.out.println(task.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(task.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
        System.out.println(task.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
    }
}
