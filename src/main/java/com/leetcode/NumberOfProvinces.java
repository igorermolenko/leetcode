package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {


    public int findCircleNum2(int[][] isConnected) {
        int result = 0;

        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                result++;
                visited[i] = true;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[cur][j] == 1 && !visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return result;
    }


    public int findCircleNum(int[][] isConnected) {
        int result = 0;

        boolean[] isVisited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                result++;
                isVisited[i] = true;
                dfs(isConnected, i, isVisited);
            }
        }
        return result;
    }

    private void dfs(int[][] isConnected, int current, boolean[] isVisited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!isVisited[j] && isConnected[current][j] == 1) {
                isVisited[j] = true;
                dfs(isConnected, j, isVisited);
            }
        }
    }





    public static void main(String[] args) {
        NumberOfProvinces task = new NumberOfProvinces();
        System.out.println(task.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(task.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(task.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
