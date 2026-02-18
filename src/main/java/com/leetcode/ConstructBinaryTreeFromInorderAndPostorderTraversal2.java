package com.leetcode;

import com.leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTree(int[] postorder, int postorderStartIdx, int postorderEndIdx,
                               int[] inorder, int inorderStartIdx, int inorderEndIdx, Map<Integer, Integer> inorderMap) {
        if (postorderStartIdx > postorderEndIdx) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEndIdx]);
        if (!inorderMap.containsKey(root.val)) {
            throw new IllegalArgumentException("Inconsistent inorder array");
        }
        int inorderRootIdx = inorderMap.get(root.val);
        int rightSize = inorderEndIdx - inorderRootIdx;

        root.right = buildTree(postorder, postorderEndIdx - rightSize, postorderEndIdx - 1,
                inorder, inorderRootIdx, inorderEndIdx, inorderMap);
        root.left = buildTree(postorder, postorderStartIdx, postorderEndIdx - rightSize - 1,
                inorder, inorderStartIdx, inorderRootIdx - 1, inorderMap);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal2 task = new ConstructBinaryTreeFromInorderAndPostorderTraversal2();
        TreeNode tree1 = task.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(tree1);
        TreeNode tree2 = task.buildTree(new int[]{-1}, new int[]{-1});
        System.out.println(tree2);
        TreeNode tree3 = task.buildTree(new int[]{9, 3, 1, 15, 2, 20, 7}, new int[]{9, 1, 2, 15, 7, 20, 3});
        System.out.println(tree3);
    }
}

