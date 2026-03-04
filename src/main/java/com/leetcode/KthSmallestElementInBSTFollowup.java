package com.leetcode;

public class KthSmallestElementInBSTFollowup {

    public int kthSmallest(AugmentedTreeNode root, int k) {
        AugmentedTreeNode current = root;

        while (current != null) {
            int leftCount = current.leftCount;

            if (k == leftCount + 1) {
                // Current node is the kth smallest
                return current.val;
            } else if (k <= leftCount) {
                // kth smallest is in left subtree
                current = current.left;
            } else {
                // kth smallest is in right subtree
                // Subtract left subtree count + current node
                k = k - leftCount - 1;
                current = current.right;
            }
        }
        throw new IllegalArgumentException("Tree doesn't have k elements");
    }

    /**
     * Build tree and compute leftCount for each node
     * Returns the total count of nodes in the subtree
     */
    public int buildLeftCounts(AugmentedTreeNode node) {
        if (node == null) {
            return 0;
        }
        node.leftCount = buildLeftCounts(node.left);
        int rightCount = buildLeftCounts(node.right);
        return node.leftCount + rightCount + 1;
    }

    /**
     * Augmented TreeNode with left subtree count
     */
    public static class AugmentedTreeNode {
        int val;
        AugmentedTreeNode left;
        AugmentedTreeNode right;
        int leftCount; // number of nodes in left subtree

        AugmentedTreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInBSTFollowup task = new KthSmallestElementInBSTFollowup();

        // Test 1: Simple tree [3, 1, 4, null, 2]
        //       3
        //      / \
        //     1   4
        //      \
        //       2
        // Inorder: 1, 2, 3, 4
        AugmentedTreeNode root1 = new AugmentedTreeNode(3);
        root1.left = new AugmentedTreeNode(1);
        root1.right = new AugmentedTreeNode(4);
        root1.left.right = new AugmentedTreeNode(2);
        task.buildLeftCounts(root1);
        System.out.println("Test 1, k=1: " + task.kthSmallest(root1, 1)); // Expected: 1
        System.out.println("Test 1, k=3: " + task.kthSmallest(root1, 3)); // Expected: 3
        System.out.println("Test 1, k=4: " + task.kthSmallest(root1, 4)); // Expected: 4

        // Test 2: Larger tree [5, 3, 6, 2, 4, null, null, 1]
        //         5
        //        / \
        //       3   6
        //      / \
        //     2   4
        //    /
        //   1
        // Inorder: 1, 2, 3, 4, 5, 6
        AugmentedTreeNode root2 = new AugmentedTreeNode(5);
        root2.left = new AugmentedTreeNode(3);
        root2.right = new AugmentedTreeNode(6);
        root2.left.left = new AugmentedTreeNode(2);
        root2.left.right = new AugmentedTreeNode(4);
        root2.left.left.left = new AugmentedTreeNode(1);
        task.buildLeftCounts(root2);
        System.out.println("Test 2, k=1: " + task.kthSmallest(root2, 1)); // Expected: 1
        System.out.println("Test 2, k=3: " + task.kthSmallest(root2, 3)); // Expected: 3
        System.out.println("Test 2, k=6: " + task.kthSmallest(root2, 6)); // Expected: 6

        // Test 3: Single node
        AugmentedTreeNode root3 = new AugmentedTreeNode(42);
        task.buildLeftCounts(root3);
        System.out.println("Test 3, k=1: " + task.kthSmallest(root3, 1)); // Expected: 42

        // Test 4: Right-skewed tree
        //     1
        //      \
        //       2
        //        \
        //         3
        AugmentedTreeNode root4 = new AugmentedTreeNode(1);
        root4.right = new AugmentedTreeNode(2);
        root4.right.right = new AugmentedTreeNode(3);
        task.buildLeftCounts(root4);
        System.out.println("Test 4, k=1: " + task.kthSmallest(root4, 1)); // Expected: 1
        System.out.println("Test 4, k=2: " + task.kthSmallest(root4, 2)); // Expected: 2
        System.out.println("Test 4, k=3: " + task.kthSmallest(root4, 3)); // Expected: 3

        // Test 5: Left-skewed tree
        //         3
        //        /
        //       2
        //      /
        //     1
        AugmentedTreeNode root5 = new AugmentedTreeNode(3);
        root5.left = new AugmentedTreeNode(2);
        root5.left.left = new AugmentedTreeNode(1);
        task.buildLeftCounts(root5);
        System.out.println("Test 5, k=1: " + task.kthSmallest(root5, 1)); // Expected: 1
        System.out.println("Test 5, k=2: " + task.kthSmallest(root5, 2)); // Expected: 2
        System.out.println("Test 5, k=3: " + task.kthSmallest(root5, 3)); // Expected: 3
    }
}
