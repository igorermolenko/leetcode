package com.leetcode;

import com.leetcode.tools.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postorderStartIdx, int postorderEndIdx,
                               int[] inorder, int inorderStartIdx, int inorderEndIdx) {
        if (postorderStartIdx > postorderEndIdx) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEndIdx]);
        for (int i = inorderEndIdx; i >= inorderStartIdx; i--) {
            if (inorder[i] == root.val) {
                int rightSize = inorderEndIdx - i;

                root.right = buildTree(postorder, postorderEndIdx - rightSize, postorderEndIdx - 1,
                        inorder, i, inorderEndIdx);
                root.left = buildTree(postorder, postorderStartIdx, postorderEndIdx - rightSize - 1,
                        inorder, inorderStartIdx, i - 1);

                return root;
            }
        }
        throw new IllegalArgumentException("Inconsistent inorder array");
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal task = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode tree1 = task.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(tree1);
        TreeNode tree2 = task.buildTree(new int[]{-1}, new int[]{-1});
        System.out.println(tree2);
        TreeNode tree3 = task.buildTree(new int[]{9, 3, 1, 15, 2, 20, 7}, new int[]{9, 1, 2, 15, 7, 20, 3});
        System.out.println(tree3);
    }
}

