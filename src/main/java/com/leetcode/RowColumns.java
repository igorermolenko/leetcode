package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RowColumns {

    public int equalPairs2(int[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                if (isEqual(grid, row, column)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isEqual(int[][] grid, int row, int column) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != grid[i][column]) {
                return false;
            }
        }
        return true;
    }

    public int equalPairs(int[][] grid) {
        int length = grid.length;
        Map<String, Integer> rowsMap = new HashMap<>();
        for (int row = 0; row < length; row++) {
            String key = Arrays.toString(grid[row]);
            rowsMap.put(key, rowsMap.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for (int column = 0; column < length; column++) {
            int[] columnArray = new int[length];
            for (int row = 0; row < length; row++) {
                columnArray[row] = grid[row][column];
            }
            String key = Arrays.toString(columnArray);
            count += rowsMap.getOrDefault(key, 0);

        }
        return count;
    }




    public static void main(String[] args) {
        RowColumns rc = new RowColumns();
        System.out.println(rc.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        System.out.println(rc.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
    }
}
