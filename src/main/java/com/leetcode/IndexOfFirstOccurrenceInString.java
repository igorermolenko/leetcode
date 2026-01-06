package com.leetcode;

import java.util.Arrays;

public class IndexOfFirstOccurrenceInString {

    public int strStr1(String haystack, String needle) {
         return haystack.indexOf(needle);
    }

    // Bruteforce
    public int strStr2(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // KMP
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        int[] lps = buildLPS(needle);

        int i = 0, j = 0;

        while (i < haystackLength) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needleLength) {
                    return i - j;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String needle) {
        int length = needle.length();
        int[] lps = new int[length];
        int j = 0, i = 1;
        lps[0] = 0;
        while (i < length) {
            if (needle.charAt(j) == needle.charAt(i)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    lps[i++] = 0;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }


    public static void main(String[] args) {
        IndexOfFirstOccurrenceInString task = new IndexOfFirstOccurrenceInString();
        System.out.println(task.strStr("abcabeabcabcabd", "abcabd"));
        System.out.println(task.strStr("abbaabbaabbab", "abbaabbab"));
        System.out.println(task.strStr("a", "a"));
        System.out.println(task.strStr("sadbutsad", "sad"));
        System.out.println(task.strStr("leetcode", "leeto"));
    }
}
