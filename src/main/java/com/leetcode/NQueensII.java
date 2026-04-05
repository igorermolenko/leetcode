package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {

    public int totalNQueens(int n) {
        List<List<Cell>> solutions = new ArrayList<>();

        addSolutions(n, 0, solutions, new ArrayList<>());

        return solutions.size();
    }

    private void addSolutions(int n, int startRow, List<List<Cell>> solutions, List<Cell> solution) {
        if (solution.size() == n) {
            solutions.add(new ArrayList<>(solution));
            return;
        }

        for (int i = startRow; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Cell cell = new Cell(i, j);
                if (isRightPlacement(cell, solution)) {
                    solution.add(cell);
                    addSolutions(n, i + 1, solutions, solution);
                    solution.removeLast();
                }
            }
        }
    }

    private boolean isRightPlacement(Cell candidate, List<Cell> solution) {
        for(Cell cell: solution) {
            if (canAttack(candidate, cell)) {
                return false;
            }
        }
        return true;
    }


    private boolean canAttack(Cell cell1, Cell cell2) {
        return cell1.row == cell2.row || cell1.col == cell2.col ||
                Math.abs(cell1.row - cell2.row) == Math.abs(cell1.col - cell2.col);
    }

    private record Cell(int row, int col) {}


    public static void main(String[] args) {
        NQueensII task = new NQueensII();
        System.out.println(task.totalNQueens(4));
        System.out.println(task.totalNQueens(1));
    }
}
