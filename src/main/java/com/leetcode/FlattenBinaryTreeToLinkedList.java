package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class FlattenBinaryTreeToLinkedList {

    public void flatten1(TreeNode root) {
        if (root != null) {
            flattenSubtree(root);
        }
    }

    public TreeNode flattenSubtree(TreeNode root) {
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;

        TreeNode current = root;
        current.left = null;

        if (leftChild != null) {
            current.right = leftChild;
            current = flattenSubtree(leftChild);
        }
        if (rightChild != null) {
            current.right = rightChild;
            current = flattenSubtree(rightChild);
        }
        return current;
    }


    public void flatten(TreeNode root) {  // Morris preorder traversal
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                current = current.right;
            } else  {
                TreeNode successor = findSuccessor(current);
                if (successor.right == null) {
                    successor.right = current;
                    current = current.left;
                } else {
                    successor.right = current.right;
                    current.right = current.left;
                    current.left = null;
                    current = successor.right;
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


    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList task = new FlattenBinaryTreeToLinkedList();
        TreeNode tree1 = createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        task.flatten(tree1);
        TreeNode tree2 = createTree(new Integer[]{});
        task.flatten(tree2);
        TreeNode tree3 = createTree(new Integer[]{0});
        task.flatten(tree3);
    }
}

