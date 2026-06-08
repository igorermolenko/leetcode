package com.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // Also can be used Prefix Tre (Trie) instead of HashMap and substring, but it adds complexity
    // With optimizations
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int maxWordLength = 0;
        for (String word : words) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.max(0, i - maxWordLength); j <= i; j++) {
                if (dp[j] && words.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // Without optimizations
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && words.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        WordBreak task = new WordBreak();
        System.out.println(task.wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(task.wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(task.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); //false
    }
}
