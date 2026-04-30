package com.leetcode;

public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int lastRowIdx = matrix.length - 1;
        int lastColIdx = matrix[0].length - 1;

        int firstRow = 0;
        int lastRow = lastRowIdx;

        while (firstRow <= lastRow) {
            int midRow = firstRow + (lastRow - firstRow) / 2;

            if (target < matrix[midRow][0]) {
                lastRow = midRow - 1;
            } else if (target > matrix[midRow][lastColIdx]) {
                firstRow = midRow + 1;
            } else {
                int firstCol = 0;
                int lastCol = lastColIdx;

                while (firstCol <= lastCol) {
                    int midCol = firstCol + (lastCol - firstCol) / 2;
                    int num = matrix[midRow][midCol];

                    if (target < num) {
                        lastCol = midCol - 1;
                    } else if (target > num) {
                        firstCol = midCol + 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        SearchIn2DMatrix task = new SearchIn2DMatrix();
        System.out.println(task.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(task.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
