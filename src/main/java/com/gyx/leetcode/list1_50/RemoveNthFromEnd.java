package com.gyx.leetcode.list1_50;

import java.util.List;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode parent = head;
        int count = 0;
        while (parent != null){
            ++count;
            parent=parent.next;
        }

        parent=head;
        for (int i = 1; i < count - n; i++) {
            parent=parent.next;
        }
        if (count == 1){
            return null;
        }
        if (count - n == 0){
            return parent.next;
        }
        parent.next = parent.next.next;
        return head;
    }

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        removeNthFromEnd.removeNthFromEnd(listNode,2);
    }
}
