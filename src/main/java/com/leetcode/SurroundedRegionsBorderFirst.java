package com.leetcode;

import com.leetcode.tools.ArrayUtils;

public class SurroundedRegionsBorderFirst {

    public void solve(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            if(board[i][0] == 'O') markRegion(board, i, 0);
            if(board[i][width - 1] == 'O') markRegion(board, i, width - 1);
        }
        for (int j = 0; j < width; j++) {
            if(board[0][j] == 'O') markRegion(board, 0, j);
            if(board[height - 1][j] == 'O') markRegion(board, height - 1, j);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markRegion(char[][] board, int row, int col) {
        board[row][col] = 'Y';
        if (row > 0 && board[row - 1][col] == 'O') markRegion(board, row - 1, col);
        if (row < board.length - 1 && board[row + 1][col] == 'O') markRegion(board, row + 1, col);
        if (col > 0 && board[row][col - 1] == 'O') markRegion(board, row, col - 1);
        if (col < board[0].length - 1 && board[row][col + 1] == 'O') markRegion(board, row, col + 1);
    }


    public static void main(String[] args) {
        SurroundedRegionsBorderFirst task = new SurroundedRegionsBorderFirst();
        char[][] grid1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        task.solve(grid1);
        System.out.println(ArrayUtils.matrixToString(grid1));
        char[][] grid2 = {{'X'}};
        task.solve(grid2);
        System.out.println(ArrayUtils.matrixToString(grid2));
        char[][] grid3 = {
                {'O', 'O', 'O'},
                {'O', 'X', 'O'},
                {'O', 'O', 'O'}
        };
        task.solve(grid3);
        System.out.println(ArrayUtils.matrixToString(grid3));
        char[][] grid4 = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        task.solve(grid4);
        System.out.println(ArrayUtils.matrixToString(grid4));
        char[][] grid5 = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'X', 'X', 'X'}
        };
        task.solve(grid5);
        System.out.println(ArrayUtils.matrixToString(grid5));
    }
}
