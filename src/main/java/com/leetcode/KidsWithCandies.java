package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> evaluate(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().orElse(0);
        return Arrays.stream(candies)
                .mapToObj(candy -> candy + extraCandies >= maxCandies)
                .toList();
    }

    public static void main(String[] args) {
        KidsWithCandies kwc = new KidsWithCandies();
        System.out.println(kwc.evaluate(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kwc.evaluate(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(kwc.evaluate(new int[]{12, 1, 12}, 10));
    }
}
