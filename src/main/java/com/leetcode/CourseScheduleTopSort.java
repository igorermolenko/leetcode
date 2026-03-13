package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleTopSort {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];
        for (int[] prerequisite : prerequisites) {
            int inId = prerequisite[0];
            int outId = prerequisite[1];
            if (graph[inId] == null) {
                graph[inId] = new Node();
            }
            if (graph[outId] == null) {
                graph[outId] = new Node();
            }
            graph[inId].inCount++;
            graph[outId].outIds.add(inId);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (graph[i] == null) {
                count++;
            } else if (graph[i].inCount == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            count++;
            Node node = graph[queue.poll()];
            for (int id : node.outIds) {
                graph[id].inCount--;
                if (graph[id].inCount == 0) {
                    queue.offer(id);
                }
            }
        }

        return count == numCourses;
    }

    private static class Node {
        int inCount = 0;
        List<Integer> outIds = new ArrayList<>();
    }


    public static void main(String[] args) {
        CourseScheduleTopSort task = new CourseScheduleTopSort();
        System.out.println(task.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(task.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
