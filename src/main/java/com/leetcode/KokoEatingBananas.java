package com.leetcode;

import java.util.Arrays;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Arrays.stream(piles).max().orElse(0);

        while (minSpeed < maxSpeed) {
            int speed = minSpeed + (maxSpeed - minSpeed) / 2;
            int hours = hoursToEat(piles, speed);
            if (hours <= h) {
                maxSpeed = speed;
            } else {
                minSpeed = speed + 1;
            }
        }

        return minSpeed;
    }

    private int hoursToEat(int[] piles, int speed) {
        int hours = 0;
        for (int pile: piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }



    public static void main(String[] args) {
        KokoEatingBananas task = new KokoEatingBananas();
        System.out.println(task.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(task.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(task.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
