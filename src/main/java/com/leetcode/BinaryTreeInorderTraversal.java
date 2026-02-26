package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTreeInorderTraversal task = new BinaryTreeInorderTraversal();

        System.out.println(task.inorderTraversal(createTree(new Integer[]{1, null, 2, 3})));
        System.out.println(task.inorderTraversal(createTree(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9})));
        System.out.println(task.inorderTraversal(createTree(new Integer[]{})));
        System.out.println(task.inorderTraversal(createTree(new Integer[]{1})));

    }
}
