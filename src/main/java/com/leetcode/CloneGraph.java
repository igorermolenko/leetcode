package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneNode(node, new HashMap<>());
    }

    private Node cloneNode(Node node, Map<Integer, Node> cloned) {
        Node clone = new Node(node.val);
        cloned.put(node.val, clone);
        node.neighbors.forEach(neighbor ->
                clone.neighbors.add(
                        cloned.containsKey(neighbor.val) ?
                                cloned.get(neighbor.val) : cloneNode(neighbor, cloned)));
        return clone;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> cloned = new HashMap<>();
        cloned.put(node.val, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node clone = cloned.get(current.val);
            for (Node neighbor : current.neighbors) {
                if (!cloned.containsKey(neighbor.val)) {
                    cloned.put(neighbor.val, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                clone.neighbors.add(cloned.get(neighbor.val));
            }
        }
        return cloned.get(node.val);
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
        Object cloned1BFS = task.cloneGraphBFS(node1);
        System.out.println(cloned1);
        System.out.println(cloned1BFS);

        Node node5 = new Node(1);
        Object cloned2 = task.cloneGraph(node5);
        Object cloned2BFS = task.cloneGraphBFS(node5);
        System.out.println(cloned2);
        System.out.println(cloned2BFS);

        System.out.println(task.cloneGraph(null));
        System.out.println(task.cloneGraphBFS(null));

    }
}
