package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestInfiniteSet {

    private int smallest = 1;
    private final Queue<Integer> returned = new PriorityQueue<>();

    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        if (returned.isEmpty()) {
            return smallest++;
        }
        Integer val = returned.poll();
        while (!returned.isEmpty() && returned.peek() == val) {
            returned.poll();
        }
        return val;
    }

    public void addBack(int num) {
        if (num < smallest) {
            returned.offer(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
    }
}
