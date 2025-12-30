package com.leetcode;

import java.util.Arrays;

public class HIndex {

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);

        int papersCount = citations.length;
        int hIndex = 0;

        for (int i = 0; i < papersCount; i++) {
            hIndex = Math.max(hIndex, Math.min((papersCount - i), citations[i]));
        }
        return hIndex;
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int papersCount = citations.length;

        for (int i = 0, count = papersCount; i < papersCount; i++, count--) {
            if (citations[i] >= count) return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex task = new HIndex();
        System.out.println(task.hIndex(new int[]{100}));
        System.out.println(task.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(task.hIndex(new int[]{1, 3, 1}));
    }
}
