package com.leetcode;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        int effectivePrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - effectivePrice - fee);
            effectivePrice = Math.min(effectivePrice, prices[i] - maxProfit);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee task = new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(task.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(task.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
