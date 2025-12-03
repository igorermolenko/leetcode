package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        LargestElementInArray task = new LargestElementInArray();
        System.out.println(task.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(task.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
