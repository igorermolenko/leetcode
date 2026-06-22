package com.leetcode;

public class CoinChangeII {

    // O(N * amount)
    public int coinChange(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }

    // O(N * amount)
    // With small optimization
    public int coinChange1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII task = new CoinChangeII();
        System.out.println(task.coinChange(5, new int[]{1, 2, 5})); // 4
        System.out.println(task.coinChange(3, new int[]{2})); // 0
        System.out.println(task.coinChange(10, new int[]{10})); // 1
    }
}
