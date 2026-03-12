package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Node node = graph.computeIfAbsent(prerequisite[0], k -> new Node());
            node.neighbors.add(prerequisite[1]);
        }

        for (Integer nodeId : graph.keySet()) {
            if (hasCycle(graph, nodeId)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, Node> graph, Integer nodeId) {
        Node node = graph.get(nodeId);
        if (node == null || node.color == Color.BLACK) {
            return false;
        } else if (node.color == Color.GRAY) {
            return true;
        }
        node.color = Color.GRAY;
        for (Integer neighborId : node.neighbors) {
            if (hasCycle(graph, neighborId)) {
                return true;
            }
        }
        node.color = Color.BLACK;
        return false;
    }


    private static class Node {
        Set<Integer> neighbors = new HashSet<>();
        Color color = Color.WHITE;
    }

    private enum Color {
        WHITE,
        GRAY,
        BLACK
    }


    public static void main(String[] args) {
        CourseSchedule task = new CourseSchedule();
        System.out.println(task.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(task.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
