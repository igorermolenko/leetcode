package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sToT.containsKey(sChar) && sToT.get(sChar) != tChar) {
                return false;
            }
            if (tToS.containsKey(tChar) && tToS.get(tChar) != sChar) {
                return false;
            }
            sToT.put(sChar, tChar);
            tToS.put(tChar, sChar);
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Character[] sToT = new Character[256];
        Character[] tToS = new Character[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sToT[sChar] != null && sToT[sChar] != tChar) {
                return false;
            }
            if (tToS[tChar] != null && tToS[tChar] != sChar) {
                return false;
            }
            sToT[sChar] = tChar;
            tToS[tChar] = sChar;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap[sChar] != tMap[tChar]) {
                return false;
            }
            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings task = new IsomorphicStrings();
        System.out.println(task.isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(task.isIsomorphic("egg", "add"));
        System.out.println(task.isIsomorphic("foo", "bar"));
        System.out.println(task.isIsomorphic("paper", "title"));
        System.out.println(task.isIsomorphic("badc", "baba"));
    }
}
