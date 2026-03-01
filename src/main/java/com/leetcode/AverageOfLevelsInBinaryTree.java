package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.leetcode.tools.TreeNode.createTree;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        long levelSum = 0;
        int levelCount = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (levelCount > 0) {
                    result.add((double) levelSum / levelCount);
                    levelSum = 0;
                    levelCount = 0;
                    if (!queue.isEmpty()) {
                        queue.offer(null);
                    }
                }
            } else {
                levelSum += node.val;
                levelCount++;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree task = new AverageOfLevelsInBinaryTree();
        System.out.println(task.averageOfLevels(createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(task.averageOfLevels(createTree(new Integer[]{3, 9, 20, 15, 7})));
    }
}
