package com.leetcode;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    // Here is solution if we need to have only unique combinations (112, 121, 211 - not unique)
    public int combinationSum4_only_unique(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = num; i <= target; i++) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV task = new CombinationSumIV();
        System.out.println(task.combinationSum4(new int[]{1, 2, 3}, 4)); // 7
        System.out.println(task.combinationSum4(new int[]{9}, 3)); // 0
    }
}
