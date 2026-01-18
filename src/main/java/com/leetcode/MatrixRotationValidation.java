package com.leetcode;

public class MatrixRotationValidation {

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length - 1;

        boolean zeroRotation = true;
        boolean firstRotation = true;
        boolean secondRotation = true;
        boolean thirdRotation = true;


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                zeroRotation = zeroRotation && mat[i][j] == target[i][j];
                firstRotation = firstRotation && mat[i][j] == target[j][n - i];
                secondRotation = secondRotation && mat[i][j] == target[n - i][n - j];
                thirdRotation = thirdRotation && mat[i][j] == target[n - j][i];
            }
        }

        return zeroRotation || firstRotation || secondRotation || thirdRotation;
    }

    public static void main(String[] args) {
        MatrixRotationValidation task = new MatrixRotationValidation();
        System.out.println(task.findRotation(new int[][]{{0, 1}, {1, 0}}, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(task.findRotation(new int[][]{{0, 1}, {1, 1}}, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(task.findRotation(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}));
    }
}
