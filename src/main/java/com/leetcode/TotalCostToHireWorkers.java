package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHireWorkers {

    public long totalCost2(int[] costs, int k, int candidates) {
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();

        int hired = 0;
        long total = 0;

        int leftIdx = 0;
        int rightIdx = costs.length - 1;

        while (hired < k) {
            if (left.size() < candidates && leftIdx <= rightIdx) {
                left.offer(costs[leftIdx++]);
            }
            if (right.size() < candidates && leftIdx <= rightIdx) {
                right.offer(costs[rightIdx--]);
            }

            if (leftIdx > rightIdx || (left.size() == candidates && right.size() == candidates)) {
                if (left.isEmpty()) {
                    total += right.poll();
                } else if (right.isEmpty()) {
                    total += left.poll();
                } else {
                    total += left.peek() <= right.peek() ? left.poll() : right.poll();
                }
                hired++;
            }

        }

        return total;
    }


    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();

        long total = 0;
        int leftIdx = 0;
        int rightIdx = costs.length - 1;

        for (int i = 0; i < candidates && leftIdx <= rightIdx; i++) {
            left.offer(costs[leftIdx++]);
        }
        for (int i = 0; i < candidates && leftIdx <= rightIdx; i++) {
            right.offer(costs[rightIdx--]);
        }
        for (int i = 0; i < k; i++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                total += left.poll();
                if (leftIdx <= rightIdx) {
                    left.offer(costs[leftIdx++]);
                }
            } else {
                total += right.poll();
                if (leftIdx <= rightIdx) {
                    right.offer(costs[rightIdx--]);
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        TotalCostToHireWorkers task = new TotalCostToHireWorkers();
        System.out.println(task.totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println(task.totalCost(new int[]{57, 33, 26, 76, 14, 67, 24, 90, 72, 37, 30}, 11, 2));
        System.out.println(task.totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }
}
