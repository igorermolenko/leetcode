package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.tools.TreeNode.createTree;

public class BinaryTreeGoodNodes {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int maxValue) {
        if (root == null) return 0;

        int newMax = Math.max(root.val, maxValue);
        int result = root.val >= maxValue ? 1 : 0;
        return result + goodNodes(root.left, newMax) + goodNodes(root.right, newMax);

    }


    public static void main(String[] args) {
        BinaryTreeGoodNodes task = new BinaryTreeGoodNodes();
        System.out.println(task.goodNodes(createTree(new Integer[]{3,1,4,3,null,1,5})));
        System.out.println(task.goodNodes(createTree(new Integer[]{3,3,null,4,2})));
        System.out.println(task.goodNodes(createTree(new Integer[]{1})));
    }
}
