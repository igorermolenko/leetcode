package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import static java.util.Arrays.asList;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);

        int counter = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                if (endWord.equals(word)) {
                    return counter;
                }
                for (int j = 0; j < word.length(); j++) {
                    char[] source = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        source[j] = ch;
                        String transformed = String.valueOf(source);
                        if (wordSet.contains(transformed)) {
                            queue.offer(transformed);
                            wordSet.remove(transformed);
                        }
                    }
                }
            }
            counter++;
        }
        return 0;
    }


    public static void main(String[] args) {
        WordLadder task = new WordLadder();
        System.out.println(task.ladderLength("hit", "cog", asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(task.ladderLength("hit", "cog", asList("hot", "dot", "dog", "lot", "log")));
    }

}