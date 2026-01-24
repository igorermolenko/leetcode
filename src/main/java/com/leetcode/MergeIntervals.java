package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leetcode.tools.ArrayUtils.matrixToString;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        MergeIntervals task = new MergeIntervals();
        System.out.println(matrixToString(task.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(matrixToString(task.merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(matrixToString(task.merge(new int[][]{{4, 7}, {1, 4}})));
        System.out.println(matrixToString(task.merge(new int[][]{{1, 10}, {2, 4}})));
        System.out.println(matrixToString(task.merge(new int[][]{{2, 4}, {1, 10}})));
        System.out.println(matrixToString(task.merge(new int[][]{{2, 4}, {7, 10}, {3, 8}})));
    }
}
