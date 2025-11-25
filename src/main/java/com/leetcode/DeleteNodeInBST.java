package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class DeleteNodeInBST {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }  else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode substitution  = getMinimum(root.right);
            root.val = substitution.val;
            root.right = deleteNode(root.right, substitution.val);
        }
        return root;
    }

    private TreeNode getMinimum(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }



    public static void main(String[] args) {
        DeleteNodeInBST task = new DeleteNodeInBST();
        System.out.println(task.deleteNode(createTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3));
        System.out.println(task.deleteNode(createTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 0));
        System.out.println(task.deleteNode(createTree(new Integer[]{}), 0));
        System.out.println(task.deleteNode(createTree(new Integer[]{5, 2, 6, null, 4, null, 7}), 0));
        System.out.println(task.deleteNode(createTree(new Integer[]{2, 0, 33, null, 1, 25, 40, null, null, 11, 31, 34, 45, 10, 18, 29, 32, null, 36, 43, 46, 4, null, 12, 24, 26, 30, null, null, 35, 39, 42, 44, null, 48, 3, 9, null, 14, 22, null, null, 27, null, null, null, null, 38, null, 41, null, null, null, 47, 49, null, null, 5, null, 13, 15, 21, 23, null, 28, 37, null, null, null, null, null, null, null, null, 8, null, null, null, 17, 19, null, null, null, null, null, null, null, 7, null, 16, null, null, 20, 6}), 33));
        System.out.println(task.deleteNode(createTree(new Integer[]{0}), 0));
    }
}
