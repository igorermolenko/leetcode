package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preLeftNode = dummyHead;
        for (int i = 1; i < left; i++) {
            preLeftNode = preLeftNode.next;
        }

        ListNode leftNode = preLeftNode.next;
        ListNode previous = leftNode;
        ListNode current = leftNode.next;

        // Rotate elements
        for (int i = 0; i < right - left; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // Repoint boundary elements
        preLeftNode.next = previous;
        leftNode.next = current;

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ReverseLinkedListII task = new ReverseLinkedListII();
        print(task.reverseBetween(createList(new int[]{1, 2, 3, 4, 5}), 2, 4));
        print(task.reverseBetween(createList(new int[]{1, 2, 3, 4, 5}), 1, 3));
        print(task.reverseBetween(createList(new int[]{5}), 1, 1));
    }
}

