package com.leetcode;

import java.util.Arrays;

public class KMP {

    public int indexOf(String str, String sample) {
        int[] lps = buildLPS(sample);
        int i = 0, j = 0;

        int sampleLength = lps.length;

        while (i < str.length()) {
            if (str.charAt(i) == sample.charAt(j)) {
                i++;
                j++;
                if (j == sampleLength) {
                    return i - sampleLength;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] buildLPS(String sample) {
        int sampleLength = sample.length();
        int[] lps = new int[sampleLength];
        lps[0] = 0;
        int i = 1, j = 0;
        while (i < sampleLength) {
            if (sample.charAt(i) == sample.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lps));
        return lps;
    }


    public static void main(String[] args) {
        KMP task = new KMP();
        System.out.println(task.indexOf("abcabeabcabcabd", "abcabd"));
        System.out.println(task.indexOf("abbaabbaabbab", "abbaabbab"));
        System.out.println(task.indexOf("a", "a"));
        System.out.println(task.indexOf("sadbutsad", "sad"));
        System.out.println(task.indexOf("leetcode", "leeto"));
    }
}
