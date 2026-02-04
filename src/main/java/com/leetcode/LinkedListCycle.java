package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        LinkedListCycle task = new LinkedListCycle();
        ListNode head1 = createList(new int[]{3, 2, 0, -4});
        head1.next.next.next.next = head1.next;
        System.out.println(task.hasCycle(head1));
        ListNode head2 = createList(new int[]{1, 2});
        head2.next.next = head2;
        System.out.println(task.hasCycle(head2));
        System.out.println(task.hasCycle((createList(new int[]{1}))));
    }
}

