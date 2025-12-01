package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestExitFromEntranceInMaze {


    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Edge> queue = new LinkedList<>();
        Set<Edge> visited = new HashSet<>();
        Edge start = new Edge(entrance[0], entrance[1]);
        queue.offer(start);
        int path = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Edge edge = queue.poll();
                if (isExit(maze, edge, start)) {
                    return path;
                }
                checkAndAddEdge(edge.x - 1, edge.y, queue, maze, visited);
                checkAndAddEdge(edge.x + 1, edge.y, queue, maze, visited);
                checkAndAddEdge(edge.x, edge.y - 1, queue, maze, visited);
                checkAndAddEdge(edge.x, edge.y + 1, queue, maze, visited);
            }
            path++;
        }
        return -1;
    }

    private void checkAndAddEdge(int x, int y, Queue<Edge> queue, char[][] maze, Set<Edge> visited) {
        if (x < 0 || y < 0 || x > maze.length - 1 || y > maze[0].length - 1 || maze[x][y] == '+') {
            return;
        }
        Edge edge = new Edge(x, y);
        if (!visited.contains(edge)) {
            queue.offer(edge);
            visited.add(edge);
        }
    }


    private boolean isExit(char[][] maze, Edge edge, Edge start) {
        if (edge.equals(start)) {
            return false;
        }
        return edge.x == 0 || edge.y == 0 || edge.x == (maze.length - 1) || edge.y == (maze[0].length - 1);
    }

    private record Edge(int x, int y) {
    }


    public static void main(String[] args) {
        NearestExitFromEntranceInMaze task = new NearestExitFromEntranceInMaze();
        System.out.println(task.nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));
        System.out.println(task.nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}));
        System.out.println(task.nearestExit(new char[][]{{'.', '+'}}, new int[]{0, 0}));
        System.out.println(task.nearestExit(new char[][]{{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','+','.','+'},{'+','+','+','+','+','+','.'}}, new int[]{0, 1}));
    }
}
