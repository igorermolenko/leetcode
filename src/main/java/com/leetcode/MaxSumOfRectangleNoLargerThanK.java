package com.leetcode;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {

    // O(n^2 * m * log(m))
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int maxSum = Integer.MIN_VALUE;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        for (int left = 0; left < colNum; left++) {
            int[] rowSum = new int[rowNum];

            for (int right = left; right < colNum; right++) {

                int curPrefix = 0;
                TreeSet<Integer> prefixes = new TreeSet<>();
                prefixes.add(curPrefix);

                for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
                    rowSum[rowIdx] += matrix[rowIdx][right];

                    curPrefix += rowSum[rowIdx];
                    // curPrefix - prevPrefix <= k    --->   curPrefix - k <=  prevPrefix
                    Integer prevPrefix = prefixes.ceiling(curPrefix - k);
                    if (prevPrefix != null) {
                        maxSum = Math.max(maxSum, curPrefix - prevPrefix);
                    }
                    prefixes.add(curPrefix);
                }
            }
        }

        return maxSum;
    }

    // The same as maxSumSubmatrix but added optimization (outer 2 cycles executed by smaller dimension) O(min(m,n)^2 * max(m, n) * log(max(m, n)))
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int maxSum = Integer.MIN_VALUE;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int firstDimensionSize = Math.min(rowNum, colNum);
        int secondDimensionSize = Math.max(rowNum, colNum);

        for (int start = 0; start < firstDimensionSize; start++) {
            int[] nums = new int[secondDimensionSize];

            for (int end = start; end < firstDimensionSize; end++) {

                int curPrefix = 0;
                TreeSet<Integer> prefixes = new TreeSet<>();
                prefixes.add(curPrefix);

                for (int idx = 0; idx < secondDimensionSize; idx++) {
                    nums[idx] += rowNum < colNum ? matrix[end][idx] : matrix[idx][end];

                    curPrefix += nums[idx];
                    Integer prevPrefix = prefixes.ceiling(curPrefix - k);
                    if (prevPrefix != null) {
                        maxSum = Math.max(maxSum, curPrefix - prevPrefix);
                    }
                    prefixes.add(curPrefix);
                }
            }
        }

        return maxSum;
    }

    // The same as maxSumSubmatrix but inner cycle replaced with 2 cycles to make more understandable    O(n*n * 2m * log(m))
    public int maxSumSubmatrix3(int[][] matrix, int k) {
        int maxSum = Integer.MIN_VALUE;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        for (int left = 0; left < colNum; left++) {
            int[] rowSum = new int[rowNum];

            for (int right = left; right < colNum; right++) {
                for (int rowIdx = 0; rowIdx < rowNum; rowIdx++) {
                    rowSum[rowIdx] += matrix[rowIdx][right];
                }

                int curPrefix = 0;
                TreeSet<Integer> prefixes = new TreeSet<>();
                prefixes.add(curPrefix);

                for (int row : rowSum) {
                    curPrefix += row;
                    Integer prevPrefix = prefixes.ceiling(curPrefix - k);
                    if (prevPrefix != null) {
                        maxSum = Math.max(maxSum, curPrefix - prevPrefix);
                    }
                    prefixes.add(curPrefix);
                }
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        MaxSumOfRectangleNoLargerThanK task = new MaxSumOfRectangleNoLargerThanK();
        System.out.println(task.maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 8));
        System.out.println(task.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        System.out.println(task.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
    }
}
