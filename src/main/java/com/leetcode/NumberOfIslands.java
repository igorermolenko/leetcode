package com.leetcode;

import com.leetcode.tools.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int counter = 0;

        int gridHeight = grid.length;
        int gridWidth = grid[0].length;

        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == '1') {
                    counter++;

                    Deque<Cell> stack = new ArrayDeque<>();
                    grid[i][j] = '2';
                    stack.push(new Cell(i, j));

                    while (!stack.isEmpty()) {
                        Cell cell = stack.pop();
                        if (cell.i > 0 && grid[cell.i - 1][cell.j] == '1') {
                            grid[cell.i - 1][cell.j] = '2';
                            stack.push(new Cell(cell.i - 1, cell.j));
                        }
                        if (cell.i < gridHeight - 1 && grid[cell.i + 1][cell.j] == '1') {
                            grid[cell.i + 1][cell.j] = '2';
                            stack.push(new Cell(cell.i + 1, cell.j));
                        }
                        if (cell.j > 0 && grid[cell.i][cell.j - 1] == '1') {
                            grid[cell.i][cell.j - 1] = '2';
                            stack.push(new Cell(cell.i, cell.j - 1));
                        }
                        if (cell.j < gridWidth - 1 && grid[cell.i][cell.j + 1] == '1') {
                            grid[cell.i][cell.j + 1] = '2';
                            stack.push(new Cell(cell.i, cell.j + 1));
                        }
                    }
                }
            }
        }
        return counter;
    }


    private record Cell(int i, int j) {
    }

    public static void main(String[] args) {
        NumberOfIslands task = new NumberOfIslands();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(task.numIslands(grid1));
        System.out.println(ArrayUtils.matrixToString(grid1));
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(task.numIslands(grid2));
        System.out.println(ArrayUtils.matrixToString(grid2));
    }
}
