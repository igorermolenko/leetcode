package com.leetcode;

import com.leetcode.tools.ArrayUtils;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int minIdx = 0, maxIdx = matrix.length - 1;

        while (minIdx < maxIdx) {
            for (int i = minIdx; i < maxIdx; i++) {
                int temp = matrix[maxIdx - i + minIdx][minIdx];
                // left column (reversed)
                matrix[maxIdx - i + minIdx][minIdx] = matrix[maxIdx][maxIdx - i + minIdx];
                // bottom row (reversed)
                matrix[maxIdx][maxIdx - i + minIdx] = matrix[i][maxIdx];
                // right column
                matrix[i][maxIdx] = matrix[minIdx][i];
                // top row
                matrix[minIdx][i] = temp;
            }
            minIdx++;
            maxIdx--;
        }
    }


    public static void main(String[] args) {
        RotateImage task = new RotateImage();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        task.rotate(matrix1);
        System.out.println(ArrayUtils.matrixToString(matrix1));
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        task.rotate(matrix2);
        System.out.println(ArrayUtils.matrixToString(matrix2));
    }
}
