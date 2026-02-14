package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previousGroupEnd = dummy;

        ListNode current = head;
        ListNode groupStart = head;
        int count = 0;

        while (current != null) {
            count++;
            ListNode next = current.next;
            if (count == k) {
                rotate(groupStart, current);
                previousGroupEnd.next = current;
                groupStart.next = next;
                previousGroupEnd = groupStart;
                groupStart = next;
                count = 0;
            }
            current = next;
        }

        return dummy.next;
    }

    private void rotate(ListNode start, ListNode end) {
        ListNode previous = null;
        ListNode current = start;
        while (previous != end) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previousGroupEnd = dummy;

        ListNode current = head;
        ListNode groupStart = head;
        int count = 0;

        while (current != null) {
            count++;
            ListNode next = current.next;

            if (count == k) {
                rotate(groupStart, current);
                previousGroupEnd.next = current;
                groupStart.next = next;
                previousGroupEnd = groupStart;
                groupStart = next;
                count = 0;
            }

            current = next;
        }

        // If incomplete group was reversed, reverse it back
        if (count > 0 && count < k) {
            ListNode lastGroupEnd = previousGroupEnd.next;
            // Find the actual end of the reversed incomplete group
            ListNode incompleteEnd = groupStart;
            while (incompleteEnd != null && incompleteEnd.next != null) {
                incompleteEnd = incompleteEnd.next;
            }
            // Reverse back is not needed - we never reversed incomplete group
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ReverseNodesInKGroup task = new ReverseNodesInKGroup();
        print(task.reverseKGroup(createList(new int[]{1, 2, 3, 4, 5}), 2));
        print(task.reverseKGroup(createList(new int[]{1, 2, 3, 4, 5}), 3));
        print(task.reverseKGroup(createList(new int[]{1, 2, 3, 4, 5}), 7));
    }
}

