package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class AddTwoNumbers {

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = null, previous = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int digit = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = digit / 10;
            ListNode next = new ListNode(digit % 10);
            if (result == null) {
                result = next;
            } else {
                previous.next = next;
            }
            previous = next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            previous.next = new ListNode(carry);
        }

        return result;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int digit = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = digit / 10;
            ListNode next = new ListNode(digit % 10);
            current.next = new ListNode(digit % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        AddTwoNumbers task = new AddTwoNumbers();
        print(task.addTwoNumbers(createList(new int[]{2, 4, 3}), createList(new int[]{5, 6, 4})));
        print(task.addTwoNumbers(createList(new int[]{0}), createList(new int[]{0})));
        print(task.addTwoNumbers(createList(new int[]{9, 9, 9, 9, 9, 9, 9}), createList(new int[]{9, 9, 9, 9})));
    }
}

