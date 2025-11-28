package com.leetcode;

import java.util.*;

import static java.util.List.of;

public class KeysAndRooms {


    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        keys.offer(0);

        while (!keys.isEmpty()) {
            int room = keys.poll();
            if (!visited.contains(room)) {
                visited.add(room);
                keys.addAll(rooms.get(room));
            }
        }
        return visited.size() == rooms.size();
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        keys.offer(0);
        visited.add(0);

        while (!keys.isEmpty()) {
            int room = keys.poll();
            for (int key : rooms.get(room)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    keys.offer(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }


    public static void main(String[] args) {
        KeysAndRooms task = new KeysAndRooms();
        System.out.println(task.canVisitAllRooms(of(of(1), of(2), of(3), of())));
        System.out.println(task.canVisitAllRooms(of(of(1, 3), of(3, 0, 1), of(23), of(0))));
    }
}
