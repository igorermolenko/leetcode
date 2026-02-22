package com.leetcode.algorithms;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class MorrisPreorderTraversal {

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
                    print(current);
                    current = current.left;
                } else {
                    successor.right = null;
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
        MorrisPreorderTraversal task = new MorrisPreorderTraversal();

        TreeNode tree1 = createTree(new Integer[]{5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, 8}); // 5,2,1,4,3,6,7,8
        task.traverse(tree1);
        System.out.println();
        TreeNode tree2 = createTree(new Integer[]{5, 4, null, 3, null, 2, null, 1, null}); // 5,4,3,2,1
        task.traverse(tree2);
    }
}
