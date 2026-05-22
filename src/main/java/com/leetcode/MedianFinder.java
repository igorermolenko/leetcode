package com.leetcode;

import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
    private final PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {
    }

    // O(log n)
    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
        } else {
            rightMinHeap.offer(num);
        }
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    //  O(1)
    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
        return leftMaxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian()); // 1, 2 -> 1.5
        finder.addNum(3);
        System.out.println(finder.findMedian()); // 1, 2, 3 -> 2
        finder.addNum(7);
        System.out.println(finder.findMedian()); // 1, 2, 3, 7 -> 2.5
        finder.addNum(1);
        System.out.println(finder.findMedian()); // 1, 1, 2, 3, 7 -> 2
        finder.addNum(1);
        System.out.println(finder.findMedian()); // 1, 1, 1, 2, 3, 7 -> 1.5
    }
}
