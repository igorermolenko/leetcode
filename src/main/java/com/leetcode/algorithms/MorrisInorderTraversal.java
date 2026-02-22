package com.leetcode.algorithms;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class MorrisInorderTraversal {

    public void traverse(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                print(current);
                current = current.right;
            } else {
                TreeNode successor = findSuccessor(current);
                if (successor.right == null) {
                    successor.right = current;
                    current = current.left;
                } else {
                    successor.right = null;
                    print(current);
                    current = current.right;
                }
            }
        }
    }

    private TreeNode findSuccessor(TreeNode root) {
        TreeNode current = root.left;
        while (current.right != null && current.right != root) {
            current = current.right;
        }
        return current;
    }

    private void print(TreeNode node) {
        System.out.print(node.val + "  ");
    }


    public static void main(String[] args) {
        MorrisInorderTraversal task = new MorrisInorderTraversal();

        TreeNode tree1 = createTree(new Integer[]{5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, 8});
        task.traverse(tree1);
        System.out.println();
        TreeNode tree2 = createTree(new Integer[]{5, 4, null, 3, null, 2, null, 1, null});
        task.traverse(tree2);
    }
}
