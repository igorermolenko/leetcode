package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }


    public static void main(String[] args) {
        ReverseLinkedList task = new ReverseLinkedList();
        print(task.reverseList(createList(new int[]{1, 2, 3, 4, 5})));
        print(task.reverseList(createList(new int[]{1, 2})));
        print(task.reverseList(createList(new int[]{})));
    }
}

