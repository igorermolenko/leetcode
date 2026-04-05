package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NQueensII2 {
    private int counter = 0;
    final private Set<Integer> columns = new HashSet<>();
    final private Set<Integer> diag1 = new HashSet<>();
    final private Set<Integer> diag2 = new HashSet<>();


    public int totalNQueens(int n) {
        counter = 0;
        columns.clear();
        diag1.clear();
        diag2.clear();
        backtrack(n, 0);
        return counter;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            counter++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2= row + col;

            if (columns.contains(col) || diag1.contains(d1) || diag2.contains(d2)) {
                continue;
            }
            columns.add(col);
            diag1.add(d1);
            diag2.add(d2);

            backtrack(n, row + 1);

            columns.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }


    public static void main(String[] args) {
        NQueensII2 task = new NQueensII2();
        System.out.println(task.totalNQueens(4));
        System.out.println(task.totalNQueens(1));
    }
}
