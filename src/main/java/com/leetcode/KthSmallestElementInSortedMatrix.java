package com.leetcode;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    // ================================================================
    // Binary search
    //  time - O(n*log(matrix[n][n] - matrix[0][0]) n), space - O(1))
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countLessEqual(int[][] matrix, int val) {
        int size = matrix.length;
        int row = 0;
        int col = size - 1;

        int count = 0;
        while (col >= 0 && row < size) {
            if (matrix[row][col] <= val) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }



    // ================================================================
    // Heap
    //  time - O(X*log n), where X = min(k, n), space - O(X))
    public int kthSmallest2(int[][] matrix, int k) {
        int size = matrix.length;

        // Arrays with 3 elements: [value][row][column]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < size; i++) {        // i < Math.min(size, k + 1)
            heap.offer(new int[]{matrix[i][0], i, 0});
        }

        while (--k > 0) {
            int[] element = heap.poll();
            int row = element[1], col = element[2];
            if (col < size - 1) {
                heap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return heap.poll()[0];
    }

    // ================================================================
    // Heap
    //  time - O(X*log n), where X = min(k, n), space - O(X)), but needs source modification
    public int kthSmallest3(int[][] matrix, int k) {
        // Arrays with 3 elements: [value][row][column]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{matrix[0][0], 0, 0});
        int size = matrix.length;

        while (--k > 0) {
            int[] element = heap.poll();
            int row = element[1], col = element[2];
            if (col < size - 1 && matrix[row][col + 1] != Integer.MIN_VALUE) {
                heap.offer(new int[]{matrix[row][col + 1], row, col + 1});
                matrix[row][col + 1] = Integer.MIN_VALUE;
            }
            if (row < size - 1 && matrix[row + 1][col] != Integer.MIN_VALUE) {
                heap.offer(new int[]{matrix[row + 1][col], row + 1, col});
                matrix[row + 1][col] = Integer.MIN_VALUE;
            }
        }
        return heap.poll()[0];
    }


    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix task = new KthSmallestElementInSortedMatrix();
        System.out.println(task.kthSmallest(new int[][]{{1, 3, 5}, {6, 7, 12}, {11, 14, 14}}, 6));
        System.out.println(task.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(task.kthSmallest(new int[][]{{-5}}, 1));
    }

}
