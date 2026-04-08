package com.leetcode;

import com.leetcode.tools.TreeNode;

public class ConvertSortedArrayToBinaryTree {


    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }
        int idx = startIdx + (endIdx - startIdx) / 2;
        TreeNode root = new TreeNode(nums[idx]);
        root.left = sortedArrayToBST(nums, startIdx, idx - 1);
        root.right = sortedArrayToBST(nums, idx + 1, endIdx);
        return root;
    }


    public static void main(String[] args) {
        ConvertSortedArrayToBinaryTree task = new ConvertSortedArrayToBinaryTree();
        TreeNode tree1 = task.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(tree1);
        TreeNode tree2 = task.sortedArrayToBST(new int[]{1, 3});
        System.out.println(tree2);
    }
}
