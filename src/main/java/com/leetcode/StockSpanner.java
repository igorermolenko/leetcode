package com.leetcode;

import java.util.*;

public class StockSpanner {

//    private List<Integer> prices = new ArrayList<>();
//
//    public int next(int price) {
//        prices.add(price);
//        int counter = 0;
//        for (int i = prices.size() - 1; i >= 0; i--) {
//            if (prices.get(i) <= price) {
//                counter++;
//            } else {
//                return counter;
//            }
//        }
//        return counter;
//    }

    private Deque<int[]> stack = new ArrayDeque<>(); // [price, span]

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner task = new StockSpanner();
        int[] prices = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int p : prices) {
            System.out.print(task.next(p) + " ");
        }
//        System.out.println(task.next(100));
//        System.out.println(task.next(80));
//        System.out.println(task.next(60));
//        System.out.println(task.next(70));
//        System.out.println(task.next(60));
//        System.out.println(task.next(75));
//        System.out.println(task.next(85));
    }
}
