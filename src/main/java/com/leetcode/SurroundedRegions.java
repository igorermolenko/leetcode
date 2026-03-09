package com.leetcode;

import com.leetcode.tools.ArrayUtils;

public class SurroundedRegions {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    boolean onTheEdge = isOnTheEdge(board, i, j);
                    mark(board, i, j, onTheEdge ? 'O' : 'X');
                }
            }
        }
    }

    private boolean isOnTheEdge(char[][] board, int row, int col) {
        if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1) return true;
        board[row][col] = 'Y';

        return board[row - 1][col] == 'O' && isOnTheEdge(board, row - 1, col) ||
                board[row][col - 1] == 'O' && isOnTheEdge(board, row, col - 1) ||
                board[row + 1][col] == 'O' && isOnTheEdge(board, row + 1, col) ||
                board[row][col + 1] == 'O' && isOnTheEdge(board, row, col + 1);
    }

    private void mark(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
        if (row > 0 && board[row - 1][col] == 'Y') {
            mark(board, row - 1, col, symbol);
        }
        if (row < board.length - 1 && board[row + 1][col] == 'Y') {
            mark(board, row + 1, col, symbol);
        }
        if (col > 0 && board[row][col - 1] == 'Y') {
            mark(board, row, col - 1, symbol);
        }
        if (col < board[0].length - 1 && board[row][col + 1] == 'Y') {
            mark(board, row, col + 1, symbol);
        }
    }


    public static void main(String[] args) {
        SurroundedRegions task = new SurroundedRegions();
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
