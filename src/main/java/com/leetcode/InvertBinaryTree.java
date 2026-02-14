package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree task = new InvertBinaryTree();
        System.out.println(task.invertTree(createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9})));
        System.out.println(task.invertTree(createTree(new Integer[]{2, 1, 3})));
        System.out.println(task.invertTree(createTree(new Integer[]{})));
    }
}

