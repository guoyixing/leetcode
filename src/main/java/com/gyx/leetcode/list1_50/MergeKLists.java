package com.gyx.leetcode.list1_50;

import com.gyx.leetcode.common.ListNode;
import static com.gyx.leetcode.list1_50.MergeTwoLists.mergeTwoLists;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }else if (lists.length == 1){
            return lists[0];
        }
        return merge(lists,0,lists.length -1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next=new ListNode(4);

        ListNode[] listNodes = new ListNode[]{l1,l2};
        MergeKLists mergeKLists = new MergeKLists();
        ListNode node = mergeKLists.mergeKLists(listNodes);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
