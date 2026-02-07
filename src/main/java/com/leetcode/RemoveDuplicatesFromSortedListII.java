package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-101);
        dummyHead.next = head;

        ListNode current = dummyHead;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int val = current.next.val;
                while (current.next != null && current.next.val == val) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII task = new RemoveDuplicatesFromSortedListII();
        print(task.deleteDuplicates(createList(new int[]{1, 1})));
        print(task.deleteDuplicates(createList(new int[]{1, 2, 3, 3, 4, 4, 5})));
        print(task.deleteDuplicates(createList(new int[]{1, 1, 1, 2, 3})));
    }
}

