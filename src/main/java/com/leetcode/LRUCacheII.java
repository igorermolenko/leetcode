package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheII {
    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);


    public LRUCacheII(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNodeLink(node);
            addNodeLinkToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNodeLink(node);
            addNodeLinkToHead(node);
        } else {
            if (map.size() == capacity) {
                Node removedNode = tail.prev;
                map.remove(removedNode.key);
                removeNodeLink(removedNode);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addNodeLinkToHead(node);
        }
    }


    private void addNodeLinkToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;

    }

    private void removeNodeLink(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }


    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LRUCacheII lRUCache = new LRUCacheII(2);
        lRUCache.put(1, 1);                     // cache is {1=1}
        lRUCache.put(2, 2);                     // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3);                     // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4);                     // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

