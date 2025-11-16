package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private static final int TIME_RANGE = 3000;

    private Queue<Integer> queue = new LinkedList<>()  ;


    public int ping(int t) {
        queue.add(t);
        Integer head = queue.peek();
        while (queue.peek() < t - TIME_RANGE) {
            queue.poll();
        }
        return queue.size();
    }


    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}
