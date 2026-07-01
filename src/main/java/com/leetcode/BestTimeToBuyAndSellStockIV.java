package com.leetcode;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {


    public int maxProfit2(int k, int[] prices) {
        int[][] hold = new int[prices.length + 1][k + 1];
        int[][] free = new int[prices.length + 1][k + 1];

        Arrays.fill(hold[0], Integer.MIN_VALUE);

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(hold[i - 1][j], free[i - 1][j - 1] - prices[i - 1]);
                free[i][j] = Math.max(free[i - 1][j], hold[i - 1][j] + prices[i - 1]);
            }
        }
        return Math.max(hold[prices.length][k], free[prices.length][k]);
    }

    // The same as above, but with optimization for case when amount of allowed transactions bigger than needed
    public int maxProfit(int k, int[] prices) {
        // Unlimited transactions
        if (k > prices.length / 2) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        int[][] hold = new int[prices.length + 1][k + 1];
        int[][] free = new int[prices.length + 1][k + 1];

        Arrays.fill(hold[0], Integer.MIN_VALUE);

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(hold[i - 1][j], free[i - 1][j - 1] - prices[i - 1]);
                free[i][j] = Math.max(free[i - 1][j], hold[i - 1][j] + prices[i - 1]);
            }
        }
        return Math.max(hold[prices.length][k], free[prices.length][k]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV task = new BestTimeToBuyAndSellStockIV();
        System.out.println(task.maxProfit(2, new int[]{2, 4, 1})); // 2
        System.out.println(task.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); // 7
    }
}
