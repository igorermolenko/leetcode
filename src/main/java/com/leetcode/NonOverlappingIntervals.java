package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int result = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < previousEnd) {
                result++;
            } else {
                previousEnd = current[1];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        NonOverlappingIntervals task = new NonOverlappingIntervals();
        System.out.println(task.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(task.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(task.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(task.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {3, 4}, {1, 5}, {2, 4}}));
    }
}
