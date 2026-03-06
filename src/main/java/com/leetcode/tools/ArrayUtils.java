package com.leetcode.tools;

public class ArrayUtils {
    public static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String matrixToString(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (char[] ints : matrix) {
            for (char anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
