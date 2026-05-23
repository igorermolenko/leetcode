package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {


    // O(Tasks.Length * log(26))
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char ch : tasks) {
            frequencies.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        PriorityQueue<Task> availableTasks = new PriorityQueue<>((a, b) -> b.count - a.count);
        frequencies.forEach((k, v) -> availableTasks.offer(new Task(k, v)));

        Map<Integer, Task> cooldownTasks = new HashMap<>();

        int timer = 0;

        while (!availableTasks.isEmpty() || !cooldownTasks.isEmpty()) {
            if (!availableTasks.isEmpty()) {
                Task task = availableTasks.poll();
                task.count--;
                if (task.count > 0) {
                    cooldownTasks.put(timer + n, task);
                }
            }
            if (cooldownTasks.containsKey(timer)) {
                availableTasks.offer(cooldownTasks.remove(timer));
            }
            timer++;
        }

        return timer;
    }

    private static class Task {
        char task;
        int count;

        public Task(char task, int count) {
            this.task = task;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        TaskScheduler task = new TaskScheduler();
        System.out.println(task.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));  // 8
        System.out.println(task.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));  // 6
        System.out.println(task.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));  // 10
    }

}
