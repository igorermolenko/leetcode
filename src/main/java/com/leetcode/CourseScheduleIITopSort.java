package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIITopSort {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] inCounts = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int inId = prerequisite[0];
            int outId = prerequisite[1];
            graph[outId].add(inId);
            inCounts[inId]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inCounts[i] == 0) {
                queue.offer(i);
            }
        }

        int[] orderedCourses = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int nodeId = queue.poll();
            orderedCourses[idx++] = nodeId;
            for (int neighborId : graph[nodeId]) {
                inCounts[neighborId]--;
                if (inCounts[neighborId] == 0) {
                    queue.offer(neighborId);
                }
            }
        }

        return idx == numCourses ? orderedCourses : new int[0];
    }


    public static void main(String[] args) {
        CourseScheduleIITopSort task = new CourseScheduleIITopSort();
        System.out.println(Arrays.toString(task.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(task.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(task.findOrder(1, new int[][]{})));
    }

}