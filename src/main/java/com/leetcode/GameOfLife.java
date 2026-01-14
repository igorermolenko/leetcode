package com.leetcode;

import com.leetcode.tools.ArrayUtils;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int neighborsCount
                        = (isAlive(board, i - 1, j - 1) ? 1 : 0)
                        + (isAlive(board, i - 1, j) ? 1 : 0)
                        + (isAlive(board, i - 1, j + 1) ? 1 : 0)
                        + (isAlive(board, i, j - 1) ? 1 : 0)
                        + (isAlive(board, i, j + 1) ? 1 : 0)
                        + (isAlive(board, i + 1, j - 1) ? 1 : 0)
                        + (isAlive(board, i + 1, j) ? 1 : 0)
                        + (isAlive(board, i + 1, j + 1) ? 1 : 0);
                int previousState = board[i][j];
                int newState = previousState;

                if (previousState == 1 && (neighborsCount < 2 || neighborsCount > 3)) {
                    newState = 0;
                } else if (previousState == 0 && neighborsCount == 3) {
                    newState = 1;
                }

                if (previousState == 0 && newState == 1) {
                    board[i][j] = 2;
                } else if (previousState == 1 && newState == 0) {
                    board[i][j] = 3;
                } else {
                    board[i][j] = newState;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private boolean isAlive(int[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        return board[row][col] == 1 || board[row][col] == 3;
    }


    public static void main(String[] args) {
        GameOfLife task = new GameOfLife();
        int[][] board1 = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        task.gameOfLife(board1);
        System.out.println(ArrayUtils.matrixToString(board1));
        int[][] board2 = {{1, 1}, {1, 0}};
        task.gameOfLife(board2);
        System.out.println(ArrayUtils.matrixToString(board2));
    }
}
