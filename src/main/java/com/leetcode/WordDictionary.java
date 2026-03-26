package com.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class WordDictionary {
    private final Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        for (char c : word.toCharArray()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (c == '.') {
                        for (Node child : node.children) {
                            queue.offer(child);
                        }
                    } else {
                        queue.offer(node.children[c - 'a']);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }

    public boolean search2(String word) {
        return search2(root, word, 0);
    }


    private boolean search2(Node node, String word, int idx) {
        if (node == null) {
            return false;
        }
        if (idx == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(idx);
        if (c == '.') {
            for (Node child : node.children) {
                if (search2(child, word, idx + 1)) {
                    return true;
                }
            }
        } else {
            return search2(node.children[c - 'a'], word, idx + 1);
        }
        return false;
    }


    private static class Node {
        boolean isWord = false;
        Node[] children = new Node[26];
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

}
