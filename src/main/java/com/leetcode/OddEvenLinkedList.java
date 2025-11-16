package com.leetcode;

import com.leetcode.tools.ListNode;

import static com.leetcode.tools.ListNode.createList;
import static com.leetcode.tools.ListNode.print;

public class OddEvenLinkedList {
    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode oddCurrent = head;
        ListNode evenCurrent = head.next;

        ListNode currentNode = head.next.next;
        boolean odd = true;
        while (currentNode != null) {
            if (odd) {
                oddCurrent.next = currentNode;
                oddCurrent = currentNode;
            } else {
                evenCurrent.next = currentNode;
                evenCurrent = currentNode;
            }

            odd = !odd;
            currentNode = currentNode.next;
        }

        oddCurrent.next = evenHead;
        evenCurrent.next = null;
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }


    public static void main(String[] args) {
        OddEvenLinkedList task = new OddEvenLinkedList();
        print(task.oddEvenList(createList(new int[]{1, 2, 3, 4, 5})));
        print(task.oddEvenList(createList(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}

