package com.leetcode;

import java.util.Arrays;

public class CoinChange {

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    // It not obviously, but with optimization
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    // One more approach with the same complexity and early exit optimization
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                if (dp[i - coin] != -1) {
                    int newDp = dp[i - coin] + 1;
                    dp[i] = dp[i] == -1 ? newDp : Math.min(dp[i], newDp);
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange task = new CoinChange();
        System.out.println(task.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(task.coinChange(new int[]{2}, 3)); // -1
        System.out.println(task.coinChange(new int[]{1}, 0)); // 0
        System.out.println(task.coinChange(new int[]{186, 419, 83, 408}, 6249)); // 20
    }
}
