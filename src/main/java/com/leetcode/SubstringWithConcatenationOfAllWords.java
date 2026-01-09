package com.leetcode;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {
            if (isSubstring(s, i, words)) {
                result.add(i);
            }

        }
        return result;
    }

    private boolean isSubstring(String s, int start, String[] words) {
        int wordLength = words[0].length();
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            int beginIndex = start + i * wordLength;
            String word = s.substring(beginIndex, beginIndex + wordLength);
            if (!wordsList.remove(word)) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLength; offset++) {
            Map<String, Integer> windowFrequency = new HashMap<>();
            int count = 0;
            int left = offset;
            for (int right = offset; right <= s.length() - wordLength; right +=  wordLength) {
                String word = s.substring(right, right + wordLength);
                if (wordFrequency.containsKey(word)) {
                    windowFrequency.put(word, windowFrequency.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowFrequency.get(word) > wordFrequency.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowFrequency.put(leftWord, windowFrequency.getOrDefault(leftWord, 0) - 1);
                        left += wordLength;
                        count--;
                    }
                    if (count == words.length) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        windowFrequency.put(leftWord, windowFrequency.getOrDefault(leftWord, 0) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    windowFrequency.clear();
                    left = right + wordLength;
                    count = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords task = new SubstringWithConcatenationOfAllWords();
        System.out.println(task.findSubstring("barfoothe", new String[]{"bar", "foo", "the"}));
        System.out.println(task.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(task.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(task.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
