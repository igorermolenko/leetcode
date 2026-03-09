package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        return cloneNode(node, new HashMap<>());
    }

    private Node cloneNode(Node node, Map<Integer, Node> cloned) {
        if (node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        cloned.put(node.val, clone);
        node.neighbors.forEach(neighbor ->
                clone.neighbors.add(
                        cloned.containsKey(neighbor.val) ?
                                cloned.get(neighbor.val) : cloneNode(neighbor, cloned)));
        return clone;
    }


    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        CloneGraph task = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Object cloned1 = task.cloneGraph(node1);
        System.out.println(cloned1);

        Node node5 = new Node(1);
        Object cloned2 = task.cloneGraph(node5);
        System.out.println(cloned2);

        System.out.println(task.cloneGraph(null));

    }
}
