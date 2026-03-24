package com.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Trie2 {
    private final TrieNode root = new TrieNode();


    public Trie2() {
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }


    private TrieNode findNode(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return null;
            }
        }
        return node;
    }


    static class TrieNode {
        boolean isWord = false;
        Map<Character, TrieNode> children = new HashMap<>();

    }




    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app"));       // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

}
