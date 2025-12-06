package com.leetcode;

import java.util.Arrays;

public class PairsSpellsAndPotions {

    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            for (int potion : potions) {
                if (((long) spells[i] * potion) >= success) {
                    pairs[i]++;
                }
            }
        }
        return pairs;
    }

    public int[] successfulPairs3(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            double minPotion = (double) success / spells[i];
            for (int potion : potions) {
                if (potion >= minPotion) {
                    pairs[i]++;
                }
            }
        }
        return pairs;
    }

    public int[] successfulPairs4(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];
            pairs[i] = potions.length - getIdx(potions, minPotion);
        }
        return pairs;
    }

    int getIdx(int[] potions, long minPotion) {
        int left = 0;
        int right = potions.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < minPotion) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] pairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];

            // Binary search ===
            int left = 0;
            int right = potions.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] < minPotion) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // Binary search ===

            pairs[i] = potions.length - left;
        }

        return pairs;
    }


    public static void main(String[] args) {
        PairsSpellsAndPotions task = new PairsSpellsAndPotions();
        System.out.println(Arrays.toString(task.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(task.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
    }
}
