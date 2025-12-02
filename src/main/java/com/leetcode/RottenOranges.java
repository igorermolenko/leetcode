package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        Set<Edge> fresh = new HashSet<>();
        Queue<Edge> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add(new Edge(i, j));
                } else if (grid[i][j] == 2) {
                    rotten.add(new Edge(i, j));
                }
            }
        }
        int minutes = 0;
        while (!rotten.isEmpty() && !fresh.isEmpty()) {
            int levelSize = rotten.size();
            for (int i = 0; i < levelSize; i++) {
                Edge edge = rotten.poll();
                processNeighbor(edge.x - 1, edge.y, grid, rotten, fresh);
                processNeighbor(edge.x + 1, edge.y, grid, rotten, fresh);
                processNeighbor(edge.x, edge.y - 1, grid, rotten, fresh);
                processNeighbor(edge.x, edge.y + 1, grid, rotten, fresh);
            }
            minutes++;
        }
        return fresh.isEmpty() ? minutes : -1;
    }

    private void processNeighbor(int x, int y, int[][] grid, Queue<Edge> rotten, Set<Edge> fresh) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        Edge edge = new Edge(x, y);
        if (fresh.remove(edge)) {
            rotten.add(edge);
        }
    }


    private record Edge(int x, int y) {}


    public static void main(String[] args) {
        RottenOranges task = new RottenOranges();
        System.out.println(task.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(task.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 0}, {1, 0, 1}}));
        System.out.println(task.orangesRotting(new int[][]{{0, 2}}));
    }
}
