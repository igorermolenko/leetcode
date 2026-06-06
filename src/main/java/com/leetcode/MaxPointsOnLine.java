package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

    // ===========================================================
    // Without HashMap - faster
    public int maxPoints(int[][] points) {
        int result = 1;

        for (int i = 0; i < points.length - 1; i++) {
            long[] slopes = new long[points.length - i - 1];
            int idx = 0;

            for (int j = i + 1; j < points.length; j++) {
                slopes[idx++] = calculateSlopeLong(points[i], points[j]);
            }
            Arrays.sort(slopes);
            int count = 1;
            long previous = slopes[0];
            for (long slope : slopes) {
                if (previous == slope) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    previous = slope;
                    count = 2;
                }
            }
            result = Math.max(result, count);
        }

        return result;
    }

    private long calculateSlopeLong(int[] point1, int[] point2) {
        int dx = point2[0] - point1[0];
        int dy = point2[1] - point1[1];
        int gcd = gcd(dx, dy);
        dx /= gcd;
        dy /= gcd;
        if (dx <= 0 && dy < 0) {
            dx = Math.abs(dx);
            dy = Math.abs(dy);
        } else if (dx < 0 || dy < 0) {
            dx = Math.abs(dx);
            dy = -Math.abs(dy);
        }
        return ((long) dx << 32) | (dy & 0xFFFFFFFFL); // Mask to ignore 32 highest 1 in the dy after it transformation to long
    }


    // ===========================================================
    // With HashMap
    public int maxPoints2(int[][] points) {
        int result = 1;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slope2count = new HashMap<>();
            int[] point1 = points[i];

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                int[] point2 = points[j];
                String slope = calculateSlopeStr(point1, point2);
                slope2count.compute(slope, (k, v) -> v == null ? 2 : v + 1);
            }
            for (int count : slope2count.values()) {
                result = Math.max(result, count);
            }
        }

        return result;
    }

    private String calculateSlopeStr(int[] point1, int[] point2) {
        int dx = point2[0] - point1[0];
        int dy = point2[1] - point1[1];
        int gcd = gcd(dx, dy);
        dx /= gcd;
        dy /= gcd;
        return dx + "," + dy;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public static void main(String[] args) {
        MaxPointsOnLine task = new MaxPointsOnLine();
        System.out.println(task.maxPoints(new int[][]{{0, 0}}));   // 1
        System.out.println(task.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));   // 3
        System.out.println(task.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));   // 4
        // {2, 3}, {1, 4} = 4-3 / 1-2 = 1 / -1 = -1
        // {3, 2}, {1, 4} = 4-2 / 1-3 = 2 / -2 = -1
        // {4, 1}, {1, 4} = 4-1 / 1-4 = 3 / -3 = -1
        System.out.println(task.maxPoints(new int[][]{{7, 3}, {19, 19}, {-16, 3}, {13, 17}, {-18, 1}, {-18, -17}, {13, -3}, {3, 7}, {-11, 12}, {7, 19}, {19, -12}, {20, -18}, {-16, -15}, {-10, -15}, {-16, -18}, {-14, -1}, {18, 10}, {-13, 8}, {7, -5}, {-4, -9}, {-11, 2}, {-9, -9}, {-5, -16}, {10, 14}, {-3, 4}, {1, -20}, {2, 16}, {0, 14}, {-14, 5}, {15, -11}, {3, 11}, {11, -10}, {-1, -7}, {16, 7}, {1, -11}, {-8, -3}, {1, -6}, {19, 7}, {3, 6}, {-1, -2}, {7, -3}, {-6, -8}, {7, 1}, {-15, 12}, {-17, 9}, {19, -9}, {1, 0}, {9, -10}, {6, 20}, {-12, -4}, {-16, -17}, {14, 3}, {0, -1}, {-18, 9}, {-15, 15}, {-3, -15}, {-5, 20}, {15, -14}, {9, -17}, {10, -14}, {-7, -11}, {14, 9}, {1, -1}, {15, 12}, {-5, -1}, {-17, -5}, {15, -2}, {-12, 11}, {19, -18}, {8, 7}, {-5, -3}, {-17, -1}, {-18, 13}, {15, -3}, {4, 18}, {-14, -15}, {15, 8}, {-18, -12}, {-15, 19}, {-9, 16}, {-9, 14}, {-12, -14}, {-2, -20}, {-3, -13}, {10, -7}, {-2, -10}, {9, 10}, {-1, 7}, {-17, -6}, {-15, 20}, {5, -17}, {6, -6}, {-11, -8}}));   // 4
    }

}
