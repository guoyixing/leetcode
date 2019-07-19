package com.gyx.leetcode.list1_50;

import com.gyx.leetcode.list1_50.MergeTwoLists.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode result = head.next;
        ListNode prepose = new ListNode(0);
        while (true) {
            ListNode front = head;
            ListNode after = front.next;
            prepose.next = after;
            if (after == null) {
                prepose.next = front;
                break;
            }
            front.next = after.next;
            after.next = front;
            if (head.next == null) {
                break;
            } else {
                prepose = head;
                head = head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        SwapPairs swapPairs = new SwapPairs();
        ListNode node = swapPairs.swapPairs(l1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
