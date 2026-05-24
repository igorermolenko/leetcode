package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {


    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> waitingTasks = new PriorityQueue<>((a, b) -> a.startTime - b.startTime);
        PriorityQueue<Task> activeTasks = new PriorityQueue<>((a, b) ->
                a.processingTime == b.processingTime ? a.idx - b.idx : a.processingTime - b.processingTime);

        for (int i = 0; i < tasks.length; i++) {
            waitingTasks.offer(new Task(i, tasks[i][0], tasks[i][1]));
        }

        int[] result = new int[tasks.length];
        int idx = 0;
        int time = 0;

        while (!waitingTasks.isEmpty() || !activeTasks.isEmpty()) {
            while (!waitingTasks.isEmpty() && waitingTasks.peek().startTime <= time) {
                activeTasks.offer(waitingTasks.poll());
            }
            if (!activeTasks.isEmpty()) {
                Task poll = activeTasks.poll();
                result[idx++] = poll.idx;
                time += poll.processingTime;
            } else {
                time = waitingTasks.peek().startTime;
            }
        }

        return result;
    }


    private record Task(int idx, int startTime, int processingTime) {
    }


    public static void main(String[] args) {
        SingleThreadedCPU task = new SingleThreadedCPU();
        System.out.println(Arrays.toString(task.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));  // 0,2,3,1
        System.out.println(Arrays.toString(task.getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));  // 4,3,2,0,1
    }

}
