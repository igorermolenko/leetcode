package com.leetcode;

import java.util.*;

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.add(product);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i < searchWord.length(); i++) {
            result.add(trie.searchByPrefix(searchWord.substring(0, i)));
        }

        return result;
    }


    private static class Trie {
        private Node root = new Node();

        public void add(String word) {
            root.add(word.toCharArray(), 0);
        }

        public List<String> searchByPrefix(String prefix) {
            List<String> words = new ArrayList<>();
            Node prefixNode = root.findByPrefix(prefix.toCharArray(), 0);
            if (prefixNode != null) {
                collectWords(prefixNode, prefix, words);
            }
            Collections.sort(words);
            return words.subList(0, Math.min(3, words.size()));
        }

        private void collectWords(Node node, String prefix, List<String> words) {
            if (node.isTerminal()) {
                words.add(prefix);
            }
            node.getChildren().entrySet().stream().forEach(entry -> {
                collectWords(entry.getValue(), prefix + entry.getKey(), words);
            });
        }
    }

    private static class Node {
        private Map<Character, Node> children = new HashMap<>();
        private boolean terminal = false;

        public void add(char[] chars, int idx) {
            if (idx == chars.length) {
                terminal = true;
                return;
            }
            Node child = children.computeIfAbsent(chars[idx], c -> new Node());
            child.add(chars, idx + 1);
        }

        public Node findByPrefix(char[] chars, int idx) {
            if (idx == chars.length) {
                return this;
            }
            Node child = children.get(chars[idx]);
            if (child != null) {
                return child.findByPrefix(chars, idx + 1);
            }
            return null;
        }

        public boolean isTerminal() {
            return terminal;
        }

        private Map<Character, Node> getChildren() {
            return children;
        }
    }


    public static void main(String[] args) {
        SearchSuggestionsSystem task = new SearchSuggestionsSystem();
        System.out.println(task.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(task.suggestedProducts(new String[]{"havana"}, "havana"));
    }
}
