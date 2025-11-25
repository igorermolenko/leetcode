package com.leetcode;

import com.leetcode.tools.TreeNode;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeSearch {


    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return searchBST(root.val > val ? root.left : root.right, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) return cur;
            cur = cur.val > val ? cur.left : cur.right;
        }
        return null;
    }


    public static void main(String[] args) {
        BinaryTreeSearch task = new BinaryTreeSearch();
        System.out.println(task.searchBST(createTree(new Integer[]{4, 2, 7, 1, 3}), 2));
        System.out.println(task.searchBST(createTree(new Integer[]{4, 2, 7, 1, 3}), 5));
    }
}
