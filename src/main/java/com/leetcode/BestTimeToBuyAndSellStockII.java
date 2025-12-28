package com.leetcode;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII task = new BestTimeToBuyAndSellStockII();
        System.out.println(task.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(task.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(task.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(task.maxProfit(new int[]{1, 5, 4, 10}));
        System.out.println(task.maxProfit(new int[]{1, 5, 5, 10}));
        System.out.println(task.maxProfit(new int[]{1, 5, 6, 10}));
    }
}
