package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int target = board.length * board.length;
        if (target == 1) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        int counter = 0;

        queue.offer(1);
        visited.add(1);

        while (!queue.isEmpty()) {
            counter++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int current = queue.poll();
                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next > target) break;  // Don't exceed board

                    next = applySnL(board, next);
                    if (next == target) {
                        return counter;
                    }
                    if (next < target && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }

        return -1;
    }


    private int applySnL(int[][] board, int squareNum) {
        int size = board.length;
        int normalizedSquareNum = squareNum - 1;
        int row = size - normalizedSquareNum / size - 1;
        int col = (normalizedSquareNum / size) % 2 == 0 ? normalizedSquareNum % size : size - normalizedSquareNum % size - 1;
        return board[row][col] == -1 ? squareNum : board[row][col];
    }


    public static void main(String[] args) {
        SnakesAndLadders task = new SnakesAndLadders();

        System.out.println(task.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println(task.snakesAndLadders(new int[][]{{-1, -1}, {-1, 3}}));
        System.out.println(task.snakesAndLadders(new int[][]{{1, 1, -1}, {1, 1, 1}, {-1, 1, 1}}));
    }

}