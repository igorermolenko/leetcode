package com.leetcode;

import java.util.Arrays;

public class Candy {

    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        System.out.println(Arrays.toString(candies));

        return Arrays.stream(candies).sum();
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int result = 1;
        int up = 0, down = 0, peak = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                down = 0;
                peak = up;
                result += up + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                up = 0;
                down++;
                result  += down + (down > peak ? 1 : 0);
            }  else {
                up = 0;
                down = 0;
                peak = 0;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Candy task = new Candy();
        System.out.println(task.candy(new int[]{7}));
        System.out.println(task.candy(new int[]{1, 0, 2}));
        System.out.println(task.candy(new int[]{1, 2, 2}));
        System.out.println(task.candy(new int[]{60, 80, 100, 100, 100, 100, 100}));
    }
}
