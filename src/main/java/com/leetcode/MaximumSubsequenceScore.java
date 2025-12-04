package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length];

        for (int i=0; i<nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }

        Arrays.sort(pairs);

        Queue<Integer> queue = new PriorityQueue<>();
        long n1Sum = 0;
        long result = 0;

        for (Pair pair : pairs) {
            n1Sum += pair.n1;
            queue.offer(pair.n1);

            if (queue.size() > k) {
                n1Sum -= queue.poll();
            }
            if (queue.size() == k) {
                result = Math.max(result, n1Sum * pair.n2);
            }

        }

        return result;
    }

    private record Pair(int n1, int n2) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.n2, n2);
        }
    }



    public static void main(String[] args) {
        MaximumSubsequenceScore task = new MaximumSubsequenceScore();
        System.out.println(task.maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
        System.out.println(task.maxScore(new int[]{2, 1, 3, 2}, new int[]{2, 1, 3, 4}, 3));
        System.out.println(task.maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1));
        System.out.println(task.maxScore(new int[]{4, 2, 3, 4, 1}, new int[]{7, 5, 10, 8, 6}, 1));
        System.out.println(task.maxScore(new int[]{2,1,14,12}, new int[]{11,7,13,6}, 3));
    }
}
