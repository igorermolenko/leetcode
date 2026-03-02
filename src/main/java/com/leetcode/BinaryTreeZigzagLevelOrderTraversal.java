package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            leftToRight = !leftToRight;
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal task = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(task.zigzagLevelOrder(createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(task.zigzagLevelOrder(createTree(new Integer[]{1})));
        System.out.println(task.zigzagLevelOrder(createTree(new Integer[]{})));
        System.out.println(task.zigzagLevelOrder(createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
    }
}
