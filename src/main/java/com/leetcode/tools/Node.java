package com.leetcode.tools;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;


    public Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return String.valueOf(val);
    }

    public static Node createTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < values.length) {
            Node current = queue.poll();

            // Add left child
            if (values[i] != null) {
                current.left = new Node(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Add right child
            if (i < values.length && values[i] != null) {
                current.right = new Node(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}
