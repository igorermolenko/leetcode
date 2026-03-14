package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite: prerequisites) {
            int inIdx = prerequisite[0];
            int outIdx = prerequisite[1];
            graph[outIdx].add(inIdx);
        }
        State[] states = new State[numCourses];
        Arrays.fill(states, State.UNVISITED);

        Index idx = new Index(numCourses - 1);
        int[] ordered = new int[numCourses];

        for (int nodeId = 0; nodeId < numCourses; nodeId++) {
            if (hasCycle(graph, states, ordered, idx, nodeId)) {
                return new int[0];
            }
        }

        return ordered;
    }


    private boolean hasCycle(List<Integer>[] graph, State[] states, int[] ordered, Index idx, int nodeId) {
        if (states[nodeId] == State.VISITED) {
            return false;
        }
        if (states[nodeId] == State.IN_PROCESS) {
            return true;
        }
        states[nodeId] = State.IN_PROCESS;
        for (int neighborId: graph[nodeId]) {
            if (hasCycle(graph, states, ordered, idx, neighborId)) {
                return true;
            }
        }
        states[nodeId] = State.VISITED;
        ordered[idx.current--] = nodeId;

        return false;
    }


    private static class Index {
        int current;
        Index(int current) {
            this.current = current;
        }
    }


    private enum State {
        UNVISITED,
        IN_PROCESS,
        VISITED
    }


    public static void main(String[] args) {
        CourseScheduleII task = new CourseScheduleII();
        System.out.println(Arrays.toString(task.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(task.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(task.findOrder(1, new int[][]{})));
    }

}