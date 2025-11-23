package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.*;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView1(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> view = new ArrayList<>();
        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(root, 0));

        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.poll();
            if (view.size() == levelNode.level) {
                view.add(levelNode.node.val);
            }
            if (levelNode.node.right != null) {
                queue.add(new LevelNode(levelNode.node.right, levelNode.level + 1));
            }
            if (levelNode.node.left != null) {
                queue.add(new LevelNode(levelNode.node.left, levelNode.level + 1));
            }
        }
        return view;
    }

    private static class LevelNode {
        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        TreeNode node;
        int level;
    }


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> view = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    view.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return view;

    }

    public static void main(String[] args) {
        BinaryTreeRightSideView task = new BinaryTreeRightSideView();
        System.out.println(task.rightSideView(createTree(new Integer[]{1, 2, 3, null, 5, null, 4})));
        System.out.println(task.rightSideView(createTree(new Integer[]{1, 2, 3, 4, null, null, null, 5})));
        System.out.println(task.rightSideView(createTree(new Integer[]{1, null, 3})));
        System.out.println(task.rightSideView(createTree(new Integer[]{})));
    }
}
