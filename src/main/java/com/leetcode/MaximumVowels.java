package com.leetcode;

public class MaximumVowels {

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(chars[i])) {
                count++;
            }
        }
        int maxCount = count;
        for (int i = k; i < chars.length; i++) {
            if (isVowel(chars[i - k])) {
                count--;
            }
            if (isVowel(chars[i])) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }


    public static void main(String[] args) {
        MaximumVowels vowels = new MaximumVowels();
        System.out.println(vowels.maxVowels("abciiidef", 3));
        System.out.println(vowels.maxVowels("aeiou", 2));
        System.out.println(vowels.maxVowels("leetcode", 3));
        System.out.println(vowels.maxVowels("rhythms", 4));
    }
}
