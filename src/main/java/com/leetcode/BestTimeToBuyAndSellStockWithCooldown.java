package com.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int hold = -prices[0], sold = 0, rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int newHold = Math.max(hold, rest - prices[i]);
            int newSold = hold + prices[i];
            int newRest = Math.max(rest, sold);

            hold = newHold;
            sold = newSold;
            rest = newRest;
        }

        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown task = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(task.maxProfit(new int[]{1, 2, 3, 0, 2}));  // 3
        System.out.println(task.maxProfit(new int[]{1})); // 0
    }
}
