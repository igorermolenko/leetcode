package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class MinimumAbsoluteDifferenceInBST {


    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode previous = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (previous != null) {
                result = Math.min(result, current.val - previous.val);
            }
            previous = current;

            current = current.right;
        }

        return result;
    }


    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST task = new MinimumAbsoluteDifferenceInBST();
        System.out.println(task.getMinimumDifference(createTree(new Integer[]{4, 2, 6, 1, 3})));
        System.out.println(task.getMinimumDifference(createTree(new Integer[]{1, 0, 48, null, null, 12, 49})));
        System.out.println(task.getMinimumDifference(createTree(new Integer[]{5, null, 8, 6})));
    }
}
