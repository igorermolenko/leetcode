package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList1(Node head) {
        Map<Node, Node> original2copy = new HashMap<>();

        Node current = head;
        while (current != null) {
            original2copy.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node copy = original2copy.get(current);
            copy.next = original2copy.get(current.next);
            copy.random = original2copy.get(current.random);
            current = current.next;
        }

        return original2copy.get(head);
    }


    public Node copyRandomList(Node head) {
        // Insert copied nodes after original
        Node current = head;
        while (current != null) {
            Node copy =  new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Setup random nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Separate lists
        Node temp = new Node(0);
        Node currentCopy = temp;
        current = head;
        while (current != null) {
            currentCopy.next = current.next;
            current.next = current.next.next;
            currentCopy = currentCopy.next;
            current = current.next;
        }

        return temp.next;
    }


    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    private static Node createList(Integer[][] nodes) {
        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < nodes.length; i++) {
            map.put(i, new Node(nodes[i][0]));
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length - 1) {
                map.get(i).next = map.get(i + 1);
            }
            if (nodes[i][1] != null) {
                map.get(i).random = map.get(nodes[i][1]);
            }
        }
        return map.get(0);
    }


    public static void main(String[] args) {
        CopyListWithRandomPointer task = new CopyListWithRandomPointer();
        Node head1 = createList(new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}});
        Node head1Copy = task.copyRandomList(head1);
        Node head2 = createList(new Integer[][]{{1, 1}, {2, 1}});
        Node head2Copy = task.copyRandomList(head2);
        Node head3 = createList(new Integer[][]{{7, null}, {3, null}, {3, 0}, {3, null}});
        Node head3Copy = task.copyRandomList(head3);
    }
}

