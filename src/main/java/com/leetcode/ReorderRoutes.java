package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutes {


    public int minReorder(int n, int[][] connections) {
        // Create bidirectional graph
        List<List<Neighbor>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(new Neighbor(connection[1], false));
            graph.get(connection[1]).add(new Neighbor(connection[0], true));
        }

        return dfs(0, graph, new boolean[n]);
    }

    private int dfs(int node, List<List<Neighbor>> graph, boolean[] visited) {
        int result = 0;
        visited[node] = true;
        for (Neighbor neighbor : graph.get(node)) {
            if (!visited[neighbor.node]) {
                result += neighbor.reverted() ? 0 : 1;
                result += dfs(neighbor.node, graph, visited);
            }
        }
        return result;
    }


    private record Neighbor(int node, boolean reverted) {
    }


    public static void main(String[] args) {
        ReorderRoutes task = new ReorderRoutes();
        System.out.println(task.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
        System.out.println(task.minReorder(6, new int[][]{{0, 1}, {4, 5}, {1, 3}, {2, 3}, {4, 0}}));
        System.out.println(task.minReorder(6, new int[][]{{0, 1}, {1, 3}, {3, 2}, {4, 0}, {4, 5}}));
        System.out.println(task.minReorder(6, new int[][]{{0, 1}, {3, 2}, {1, 3}, {4, 0}, {4, 5}}));
        System.out.println(task.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
        System.out.println(task.minReorder(3, new int[][]{{1, 0}, {2, 0}}));
    }
}
