package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.leetcode.tools.TreeNode.createTree;

public class SumRootToLeafNumbers {
    private static final TreeNode MARKER = new TreeNode(Integer.MIN_VALUE);


    public int sumNumbers2(TreeNode root) {
        int sum = 0;

        Deque<TreeNode> path = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();
            if (current != MARKER) {
                if (current.left == null && current.right == null) {
                    StringBuilder number = new StringBuilder();
                    path.iterator().forEachRemaining(node -> number.append(node.val));
                    number.append(current.val);
                    sum += Integer.parseInt(number.toString());
                } else {
                    stack.addLast(MARKER);
                    if (current.right != null) stack.addLast(current.right);
                    if (current.left != null) stack.addLast(current.left);
                    path.addLast(current);
                }
            } else {
                path.removeLast();
            }
        }
        return sum;
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int currentNum = 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();
            if (current != MARKER) {
                if (current.left == null && current.right == null) {
                    sum += currentNum * 10 + current.val;
                } else {
                    stack.addLast(MARKER);
                    if (current.right != null) stack.addLast(current.right);
                    if (current.left != null) stack.addLast(current.left);
                    currentNum = currentNum * 10 + current.val;
                }
            } else {
                currentNum /= 10;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        SumRootToLeafNumbers task = new SumRootToLeafNumbers();
        System.out.println(task.sumNumbers(createTree(new Integer[]{1, 2, 3})));
        System.out.println(task.sumNumbers(createTree(new Integer[]{4, 9, 0, 5, 1})));
    }
}
