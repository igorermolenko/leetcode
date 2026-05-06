package com.leetcode;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int min = Arrays.stream(weights).max().getAsInt();
        int max = Arrays.stream(weights).sum();

        while (min < max) {
            int mid = min + (max - min) / 2;

            if (canBeShipped(weights, days, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean canBeShipped(int[] weights, int days, int capacity) {
        int neededDays = 0;
        int restCapacity = 0;

        for (int weight : weights) {
            if (restCapacity < weight) {
                restCapacity = capacity;
                neededDays++;
            }
            restCapacity -= weight;
        }

        return neededDays <= days;
    }


    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays task = new CapacityToShipPackagesWithinDDays();
        System.out.println(task.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(task.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(task.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println(task.shipWithinDays(new int[]{31, 2, 3, 1, 1}, 4));
    }
}
