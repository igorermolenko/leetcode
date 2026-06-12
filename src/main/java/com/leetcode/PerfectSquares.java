package com.leetcode;

import java.util.Arrays;

public class PerfectSquares {
    private static final int MAX_SQUARE = 100;

    // O(n * sqr(n))
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= MAX_SQUARE; j++) {
                int square = j * j;
                if (i < square) break;
                int count = 1 + dp[i - square];
                dp[i] = Math.min(dp[i], count);
            }
        }

        return dp[n];
    }

    // It's not obvious, but with optimization
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j <= MAX_SQUARE; j++) {
            int square = j * j;
            for (int i = square; i <= n; i++) {
                int count = 1 + dp[i - square];
                dp[i] = Math.min(dp[i], count);
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        PerfectSquares task = new PerfectSquares();
        System.out.println(task.numSquares(12)); // 3
        System.out.println(task.numSquares(13)); // 2
    }
}
