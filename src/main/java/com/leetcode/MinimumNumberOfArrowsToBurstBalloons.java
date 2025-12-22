package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int result = 1;
        int maxPrevStart = points[0][0];
        int minPrevEnd = points[0][1];;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= minPrevEnd && points[i][1] >= maxPrevStart) {
                maxPrevStart = Math.max(maxPrevStart, points[i][0]);
                minPrevEnd = Math.min(minPrevEnd, points[i][1]);
            } else {
                result++;
                maxPrevStart = points[i][0];
                minPrevEnd = points[i][1];
            }
        }

        return result;
    }


    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(o -> o[1]));
        int result = 1;
        int arrow =  points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrow) {
                result++;
                arrow = points[i][1];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons task = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(task.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(task.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(task.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(task.findMinArrowShots(new int[][]{{1, 2}, {2, 9}, {1, 4}, {5, 8}, {1, 3}, {5, 7}, {2, 3}, {3, 5}, {5, 6}}));
        System.out.println(task.findMinArrowShots(new int[][]{{11, 12}, {12, 19}, {11, 14}, {15, 18}, {11, 13}, {15, 17}, {12, 13}, {13, 15}, {15, 16}}));
        System.out.println(task.findMinArrowShots(new int[][]{{-2147483648, 2147483647}}));
    }
}
