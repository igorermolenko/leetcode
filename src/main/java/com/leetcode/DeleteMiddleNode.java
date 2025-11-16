package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args) {
        DeleteMiddleNode dmn = new DeleteMiddleNode();
        print(dmn.deleteMiddle(createList(new int[]{1, 3, 4, 7, 1, 2, 6})));
        print(dmn.deleteMiddle(createList(new int[]{1, 2, 3, 4})));
        print(dmn.deleteMiddle(createList(new int[]{2, 1})));
    }
}

