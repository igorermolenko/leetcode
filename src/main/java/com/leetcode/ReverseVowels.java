package com.leetcode;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            boolean isVowelI = isVowel(chars[i]);
            boolean isVowelJ = isVowel(chars[j]);

            if (isVowelI && isVowelJ) {
                char buf = chars[i];
                chars[i++] = chars[j];
                chars[j--] = buf;
            } else {
                if (!isVowelI) i++;
                if (!isVowelJ) j--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }


    public static void main(String[] args) {
        ReverseVowels vowels = new ReverseVowels();
        System.out.println(vowels.reverseVowels("IceCreAm"));
        System.out.println(vowels.reverseVowels("leetcode"));
        System.out.println(vowels.reverseVowels("aBracAdAbrA"));
    }
}
