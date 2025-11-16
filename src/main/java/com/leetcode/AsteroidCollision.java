package com.leetcode;

import java.util.Arrays;

public class AsteroidCollision {

    public int[] asteroidCollision2(int[] asteroids) {
        int position = 0;
        for (int a : asteroids) {
            if (a > 0) {
                asteroids[position++] = a;
            } else {
                if (position == 0 || asteroids[position - 1] < 0) {
                    asteroids[position++] = a;
                } else {
                    int collisionResult = a;
                    do {
                        int b = asteroids[--position];
                        if (Math.abs(collisionResult) == Math.abs(b)) {
                            collisionResult = 0;
                        } else {
                            collisionResult = Math.abs(collisionResult) > Math.abs(b) ? collisionResult : b;
                        }
                    } while (collisionResult < 0 && position > 0 && asteroids[position-1] > 0);
                    if (collisionResult != 0) {
                        asteroids[position++] = collisionResult;
                    }
                }
            }
        }
        return Arrays.copyOfRange(asteroids, 0, position);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int position = 0;
        for (int a : asteroids) {
            if (a > 0) {
                asteroids[position++] = a;
            } else {
                while (position > 0 && asteroids[position - 1] > 0 && a < 0) {
                    int b = asteroids[--position];
                    if (Math.abs(a) == Math.abs(b)) {
                        a = 0;
                        break;
                    } else if (Math.abs(a) < Math.abs(b)) {
                        a = b;
                    }
                }
                if (a != 0) {
                    asteroids[position++] = a;
                }
            }
        }
        return Arrays.copyOfRange(asteroids, 0, position);
    }

    public static void main(String[] args) {
        AsteroidCollision asteroids = new AsteroidCollision();
        System.out.println(java.util.Arrays.toString(asteroids.asteroidCollision(new int[] {5,10,-5})));
        System.out.println(java.util.Arrays.toString(asteroids.asteroidCollision(new int[] {8,-8})));
        System.out.println(java.util.Arrays.toString(asteroids.asteroidCollision(new int[] {10,2,-5})));
        System.out.println(java.util.Arrays.toString(asteroids.asteroidCollision(new int[] {3,5,-6,2,-1,4})));
        System.out.println(java.util.Arrays.toString(asteroids.asteroidCollision(new int[] {-2,-1,1,2})));
        System.out.println(java.util.Arrays.toString(asteroids.asteroidCollision(new int[] {-2,-2,1,-2})));
    }
}
