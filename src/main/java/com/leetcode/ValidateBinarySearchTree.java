package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode previous = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (previous != null && previous.val >= current.val) {
                return false;
            }

            previous = current;
            current = current.right;

        }
        return true;
    }


    public static void main(String[] args) {
        ValidateBinarySearchTree task = new ValidateBinarySearchTree();
        System.out.println(task.isValidBST(createTree(new Integer[]{2, 1, 3})));
        System.out.println(task.isValidBST(createTree(new Integer[]{5, 1, 4, null, null, 3, 6})));
    }
}
