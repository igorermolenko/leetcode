package com.leetcode;

import com.leetcode.tools.ArrayUtils;

public class SetMatrixZeros {

    public void setZeroes2(int[][] matrix) {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        boolean[] rows = new boolean[rowsCount];
        boolean[] columns = new boolean[colsCount];

        int a = Integer.MAX_VALUE;

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < rowsCount; i++) {
            if (rows[i]) {
                for (int j = 0; j < colsCount; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < colsCount; j++) {
            if (columns[j]) {
                for (int i = 0; i < rowsCount; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public void setZeroes(int[][] matrix) {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;

        boolean firstRowZero = false, firstColZero = false;

        for (int i = 0; i < rowsCount; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < colsCount; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowsCount; i++) {
            for (int j = 1; j < colsCount; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < colsCount; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < rowsCount; i++) {
                matrix[i][0] = 0;
            }
        }



    }


    public static void main(String[] args) {
        SetMatrixZeros task = new SetMatrixZeros();
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        task.setZeroes(matrix1);
        System.out.println(ArrayUtils.matrixToString(matrix1));
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        task.setZeroes(matrix2);
        System.out.println(ArrayUtils.matrixToString(matrix2));
    }
}
