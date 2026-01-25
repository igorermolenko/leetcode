package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.tools.ArrayUtils.matrixToString;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        InsertInterval task = new InsertInterval();
        System.out.println(matrixToString(task.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(matrixToString(task.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(matrixToString(task.insert(new int[][]{{2, 3}, {6, 9}}, new int[]{1, 5})));
        System.out.println(matrixToString(task.insert(new int[][]{{3, 5}}, new int[]{1, 2})));
        System.out.println(matrixToString(task.insert(new int[][]{}, new int[]{2, 5})));
    }
}
