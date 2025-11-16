package com.leetcode;

import java.util.*;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> chars1 = getFrequenceiesMap(word1);
        Map<Character, Integer> chars2 = getFrequenceiesMap(word2);

        if (!chars1.keySet().equals(chars2.keySet())) {
            return false;
        }

        List<Integer> frequencies1 = new ArrayList<>(chars1.values());
        List<Integer> frequencies2 = new ArrayList<>(chars2.values());
        Collections.sort(frequencies1);
        Collections.sort(frequencies2);

        return frequencies1.equals(frequencies2);
    }

    private Map<Character, Integer> getFrequenceiesMap(String word) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char ch : word.toCharArray()) {
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }
        return chars;
    }


    public static void main(String[] args) {
        CloseStrings strings = new CloseStrings();
        System.out.println(strings.closeStrings("abc", "bca"));
        System.out.println(strings.closeStrings("uau", "ssx"));
        System.out.println(strings.closeStrings("a", "aa"));
        System.out.println(strings.closeStrings("cabbba", "abbccc"));
    }
}
