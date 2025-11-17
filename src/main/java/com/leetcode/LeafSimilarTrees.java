package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.tools.TreeNode.createTree;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2= new ArrayList<>();
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }


    public static void main(String[] args) {
        LeafSimilarTrees task = new LeafSimilarTrees();
        System.out.println(task.leafSimilar(
                createTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}),
                createTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8})));
        System.out.println(task.leafSimilar(
                createTree(new Integer[]{1, 2, 3}),
                createTree(new Integer[]{3, 2, 1})));
    }
}
