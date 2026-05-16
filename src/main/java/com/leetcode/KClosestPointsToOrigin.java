package com.leetcode;

import java.util.Arrays;

import static com.leetcode.tools.ArrayUtils.bidimensialToString;

public class KClosestPointsToOrigin {


    // Quickselect Hoar Method    time - O(n) average and O(n²) worst case, space - O(1)
    public int[][] kClosest2(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;

        while (left <= right) {
            int pivotIdx = partition(points, left, right);

            if (pivotIdx + 1 == k) {
                return Arrays.copyOfRange(points, 0, pivotIdx + 1);
            }
            if (pivotIdx + 1 < k) {
                left = pivotIdx + 1;
            } else {
                right = pivotIdx;
            }
        }

        return new int[0][];
    }

    private int partition(int[][] points, int left, int right) {
        int pivotIdx = left + (right - left) / 2;
        int pivot = getDistance(points[pivotIdx]);

        int i = left - 1;
        int j = right + 1;

        while (true) {
            do {
                i++;
            } while (getDistance(points[i]) < pivot);
            do {
                j--;
            } while (getDistance(points[j]) > pivot);

            if (i >= j) {
                return j;
            }
            int[] temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }
    }



    // Quickselect Lomuto Method   time - O(n) average and O(n²) worst case, space - O(1)
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            int pivotIdx = partitionLomuto(points, left, right);
            if (pivotIdx + 1 == k) {
                return Arrays.copyOfRange(points, 0, pivotIdx + 1);
            }
            if (pivotIdx + 1 < k) {
                left = pivotIdx + 1;
            } else  {
                right = pivotIdx - 1;
            }
        }
        return new int[0][];
    }

    private int partitionLomuto(int[][] points, int left, int right) {
        int pivot = getDistance(points[right]);
        int i = left;
        for (int j = left; j <= right; j++) {
            if (getDistance(points[j]) <= pivot) {
                if (i != j) {
                   int[] temp = points[j];
                   points[j] = points[i];
                   points[i] = temp;
                }
                i++;
            }
        }
        return i - 1;
    }


    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    public static void main(String[] args) {
        KClosestPointsToOrigin task = new KClosestPointsToOrigin();
        System.out.println(bidimensialToString(task.kClosest(new int[][]{{-95, 76}, {17, 7}, {-55, -58}, {53, 20}, {-69, -8}, {-57, 87}, {-2, -42}, {-10, -87}, {-36, -57}, {97, -39}, {97, 49}}, 5)));
        System.out.println(bidimensialToString(task.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(bidimensialToString(task.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
        System.out.println(bidimensialToString(task.kClosest(new int[][]{{0, 1}, {1, 0}}, 2)));
    }

}
