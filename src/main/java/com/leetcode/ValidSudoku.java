package com.leetcode;

public class ValidSudoku {

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] digits = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!isValid(board[i][j], digits)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] digits = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!isValid(board[j][i], digits)) {
                    return false;
                }
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                boolean[] digits = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!isValid(board[k * 3 + i][l * 3 + j], digits)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean isValid(char ch, boolean[] digits) {
        if (ch != '.') {
            if (digits[ch - '1']) {
                return false;
            }
            digits[ch - '1'] = true;
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int boxIdx = (i / 3) * 3 + j / 3;

                    int digit = ch - '1';

                    if (rows[i][digit] || columns[j][digit] || boxes[boxIdx][digit]) {
                        return false;
                    }

                    rows[i][digit] = true;
                    columns[j][digit] = true;
                    boxes[boxIdx][digit] = true;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ValidSudoku task = new ValidSudoku();
        System.out.println(task.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        ));
        System.out.println(task.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        ));
        System.out.println(task.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '8', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        ));
    }
}
