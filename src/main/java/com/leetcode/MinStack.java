package com.leetcode;

public class MinStack {
    private Node head = null;


    public void push(int val) {
        head = new Node(val, head);
    }

    public void pop() {
        head = head != null ? head.previous : null;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }


    private static class Node {
        int val;
        int min;
        Node previous;

        public Node(int val, Node previous) {
            this.val = val;
            this.previous = previous;
            min = previous != null ? Math.min(val, previous.min) : val;
        }
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
