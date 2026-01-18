package com.leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<Map<Character, Integer>, List<String>> alphabet2words = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> chars = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                chars.put(str.charAt(i), chars.getOrDefault(str.charAt(i), 0) + 1);
            }
            alphabet2words.computeIfAbsent(chars, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(alphabet2words.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> alphabet2words = new HashMap<>();

        for (String str : strs) {
            int[] chars = new int[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            alphabet2words.computeIfAbsent(Arrays.toString(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(alphabet2words.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> alphabet2words = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            alphabet2words.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(alphabet2words.values());
    }

    public static void main(String[] args) {
        GroupAnagrams task = new GroupAnagrams();
        System.out.println(task.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        System.out.println(task.groupAnagrams(new String[] {}));
        System.out.println(task.groupAnagrams(new String[] {"a"}));
    }
}
