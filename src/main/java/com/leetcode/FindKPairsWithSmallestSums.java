package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // int[] - array of 3 elements (nums1[idx1], nums2[idx2], idx2).
        // idx1 not needed, because we are initially adding all elements from nums1
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1]))); // new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Initialize the heap with the first element of each row
        // We only need at most 'k' rows, because we only need 'k' pairs total.
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        }
//        for (int num : nums1) {
//            heap.offer(new int[]{num, nums2[0], 0});
//        }

        // Step 2: Pop the smallest sum, and push the next element in that same row
        while (k-- > 0) {
            int[] candidate = heap.poll();
            result.add(List.of(candidate[0], candidate[1]));
            if (candidate[2] < nums2.length - 1) {
                int idx2 = candidate[2] + 1;
                heap.offer(new int[]{candidate[0], nums2[idx2], idx2});
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FindKPairsWithSmallestSums task = new FindKPairsWithSmallestSums();
        System.out.println(task.kSmallestPairs(new int[]{1, 2, 4, 5, 6}, new int[]{3, 5, 7, 9}, 3));
        System.out.println(task.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(task.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }

}
