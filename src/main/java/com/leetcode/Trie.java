package com.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    private Node root = new Node();


    public Trie() {
    }

    public void insert(String word) {
        root.insert(word.toCharArray(), 0);
    }

    public boolean search(String word) {
        return root.search(word.toCharArray(), 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix.toCharArray(), 0);
    }


    private static class Node {
        private Map<Character, Node> children = new HashMap<>();

        private void insert(char[] chars, int idx) {
            if (idx == chars.length) {
                children.put(null, new Node());
                return;
            }
            Node child = children.computeIfAbsent(chars[idx], c -> new Node());
            child.insert(chars, idx + 1);
        }

        private boolean search(char[] chars, int idx) {
            if (idx == chars.length) {
                return children.containsKey(null) ;
            }
            Node child = children.get(chars[idx]);
            if (child == null) {
                return false;
            }
            return child.search(chars, idx + 1);
        }

        private boolean startsWith(char[] chars, int idx) {
            if (idx == chars.length) {
                return true;
            }
            Node child = children.get(chars[idx]);
            if (child == null) {
                return false;
            }
            return child.startsWith(chars, idx + 1);
        }


    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app"));       // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

}
