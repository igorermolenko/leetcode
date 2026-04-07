package com.leetcode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    if (exist(board, chars, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] word, int idx, int row, int col) {
        if (idx == word.length) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word[idx]) {
            return false;
        }

        char buffer = board[row][col];
        board[row][col] = '*';

        boolean exist = exist(board, word, idx + 1, row - 1, col) ||
                exist(board, word, idx + 1, row + 1, col) ||
                exist(board, word, idx + 1, row, col - 1) ||
                exist(board, word, idx + 1, row, col + 1);

        board[row][col] = buffer;

        return exist;
    }


    public static void main(String[] args) {
        WordSearch task = new WordSearch();
        System.out.println(task.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(task.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(task.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
