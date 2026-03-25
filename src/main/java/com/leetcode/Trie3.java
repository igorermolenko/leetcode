package com.leetcode;


public class Trie3 {
    private final TrieNode root = new TrieNode();


    public Trie3() {
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode nextNode = node.children[c - 'a'];
            if (nextNode == null) {
                nextNode = new TrieNode();
                node.children[c - 'a'] = nextNode;
            }
            node = nextNode;
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
        for (char c : prefix.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }


    static class TrieNode {
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
    }


    public static void main(String[] args) {
        Trie3 trie = new Trie3();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app"));       // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

}
