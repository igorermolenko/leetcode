package com.leetcode;

public class NumberOfDiceRollsWithTargetSum {
    private static final int MODULO = 1000000007;

    // O(n * target * k)
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int diceCount = 1; diceCount <= n; diceCount++) {
            for (int currentTarget = diceCount; currentTarget <= target; currentTarget++) {
                int availableOptions = Math.min(k, currentTarget);
                for (int i = 1; i <= availableOptions; i++) {
                    dp[diceCount][currentTarget] += dp[diceCount - 1][currentTarget - i];
                    dp[diceCount][currentTarget] %= MODULO;
                }
            }
        }

        return dp[n][target];
    }


    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum task = new NumberOfDiceRollsWithTargetSum();
        System.out.println(task.numRollsToTarget(1, 6, 3)); // 1
        System.out.println(task.numRollsToTarget(2, 6, 7)); // 6
        System.out.println(task.numRollsToTarget(3, 6, 7)); // 15
        System.out.println(task.numRollsToTarget(30, 30, 500)); // 222616187
    }
}
