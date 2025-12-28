package com.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock task = new BestTimeToBuyAndSellStock();
        System.out.println(task.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(task.maxProfit(new int[]{7, 3, 5, 6, 1, 4}));
        System.out.println(task.maxProfit(new int[]{7, 1, 9, 3, 15, 4}));
        System.out.println(task.maxProfit(new int[]{7, 9, 1, 3, 15, 4}));
        System.out.println(task.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
