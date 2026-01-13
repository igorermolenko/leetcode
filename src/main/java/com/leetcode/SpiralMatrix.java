package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int firstRow = 0, lastRow = matrix.length - 1;
        int firstCol = 0, lastCol = matrix[0].length - 1;
        boolean horizontalDirection = true;
        boolean forwardDirection = true;

        while (firstRow <= lastRow && firstCol <= lastCol) {
            if (horizontalDirection) {
                if (forwardDirection) {
                    for (int j = firstCol; j <= lastCol; j++) {
                        list.add(matrix[firstRow][j]);
                    }
                    firstRow++;
                } else {
                    for (int j = lastCol; j >= firstCol; j--) {
                        list.add(matrix[lastRow][j]);
                    }
                    lastRow--;
                }
                horizontalDirection = false;
            } else {
                if (forwardDirection) {
                    for (int i = firstRow; i <= lastRow; i++) {
                        list.add(matrix[i][lastCol]);
                    }
                    lastCol--;
                    forwardDirection = false;
                } else {
                    for (int i = lastRow; i >= firstRow; i--) {
                        list.add(matrix[i][firstCol]);
                    }
                    firstCol++;
                    forwardDirection = true;
                }
                horizontalDirection = true;
            }
        }

        return list;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }

        public static void main (String[] args){
            SpiralMatrix task = new SpiralMatrix();
            System.out.println(task.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
            System.out.println(task.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        }
    }
