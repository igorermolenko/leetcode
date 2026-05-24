package com.leetcode;

import com.leetcode.tools.ArrayUtils;

public class FlipSquareSubmatrixVertically {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int firstRow = x;
        int lastRow = x + k - 1;

        while (firstRow < lastRow) {
            for (int i = y; i < y + k; i++) {
                int temp = grid[firstRow][i];
                grid[firstRow][i] = grid[lastRow][i];
                grid[lastRow][i] = temp;
            }
            firstRow++;
            lastRow--;
        }

        return grid;
    }


    public static void main(String[] args) {
        FlipSquareSubmatrixVertically task = new FlipSquareSubmatrixVertically();
        System.out.println(ArrayUtils.matrixToString(task.reverseSubmatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 1, 0, 3)));
        System.out.println(ArrayUtils.matrixToString(task.reverseSubmatrix(new int[][]{{3,4,2,3}, {2,3,4,2}}, 0, 2, 2)));
    }

}
