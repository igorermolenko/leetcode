package com.leetcode;

import com.leetcode.tools.Node;

import java.util.LinkedList;
import java.util.Queue;

import static com.leetcode.tools.Node.createTree;


public class PopulatingNextRightPointersInEachNodeII {

    public Node connect2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current != null) {
                while (current != null) {
                    Node next = queue.poll();
                    current.next = next;
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    current = next;
                }
                queue.offer(null);
            }
        }

        return root;
    }


    public Node connect(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node current = levelStart;
            Node nextLevelStart = null;
            Node nextLevelTail = null;

            while (current != null) {
                if (current.left != null) {
                    if (nextLevelTail != null) {
                        nextLevelTail.next = current.left;
                    } else {
                        nextLevelStart = current.left;
                    }
                    nextLevelTail = current.left;
                }
                if (current.right != null) {
                    if (nextLevelTail != null) {
                        nextLevelTail.next = current.right;
                    } else {
                        nextLevelStart = current.right;
                    }
                    nextLevelTail = current.right;
                }
                current = current.next;
            }

            levelStart = nextLevelStart;
        }

        return root;
    }


    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII task = new PopulatingNextRightPointersInEachNodeII();
        Node tree1 = createTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        Node tree1Updated = task.connect(tree1);
        Node tree2 = createTree(new Integer[]{});
        Node tree2Updated = task.connect(tree2);
    }
}

