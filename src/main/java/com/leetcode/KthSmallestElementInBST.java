package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class KthSmallestElementInBST {


    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        int currentIdx = 0;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (++currentIdx == k) {
                return current.val;
            }

            current = current.right;
        }
        throw new IllegalArgumentException("Tree doesn't have " + k + " elements");
    }


    public static void main(String[] args) {
        KthSmallestElementInBST task = new KthSmallestElementInBST();
        System.out.println(task.kthSmallest(createTree(new Integer[]{3, 1, 4, null, 2}), 1));
        System.out.println(task.kthSmallest(createTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3));
    }
}
