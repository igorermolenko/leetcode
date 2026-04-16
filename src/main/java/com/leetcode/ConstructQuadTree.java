package com.leetcode;

public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    public Node construct(int[][] grid, int x, int y, int size) {
        if (size == 1) {
            return new Node(grid[x][y] == 1, true);
        }

        int newSize = size / 2;

        Node topLeft = construct(grid, x, y, newSize);
        Node topRight = construct(grid, x, y + newSize, newSize);
        Node bottomLeft = construct(grid, x + newSize, y, newSize);
        Node bottomRight = construct(grid, x + newSize, y + newSize, newSize);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }


    public static void main(String[] args) {
        ConstructQuadTree task = new ConstructQuadTree();
        Node tree1 = task.construct(new int[][]{{0, 1}, {1, 0}});
        Node tree2 = task.construct(new int[][]
                {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}}
        );
    }


    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
