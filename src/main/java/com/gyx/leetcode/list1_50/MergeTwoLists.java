package com.gyx.leetcode.list1_50;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }else if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }

        ListNode listNode;
        if (l1.val < l2.val) {
            listNode = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            listNode = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode node = listNode;
        merge(node, l1, l2);
        return listNode;
    }

    private void merge(ListNode listNode, ListNode l1, ListNode l2) {
        if (l1 == null) {
            listNode.next = l2;
            return;
        }
        if (l2 == null) {
            listNode.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            listNode = listNode.next = l1;
            l1 = l1.next;
        } else {
            listNode = listNode.next = l2;
            l2 = l2.next;
        }
        merge(listNode, l1, l2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2).next=new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3).next=new ListNode(4);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode node = mergeTwoLists.mergeTwoLists(l1, l2);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
