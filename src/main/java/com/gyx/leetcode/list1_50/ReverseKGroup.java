package com.gyx.leetcode.list1_50;

import com.gyx.leetcode.common.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = k;
        ListNode[] stack = new ListNode[k];
        ListNode q = head;
        while(k>0) {
            stack[i-k] = q;
            if (q!=null){
                q=q.next;
            }else{
                return head;
            }
            k--;
        }
        while(k<i-1) {
            k++;
            stack[i-k].next=stack[i-k-1];
        }
        stack[0].next=reverseKGroup(q, k+1);
        return stack[i-1];
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node = reverseKGroup.reverseKGroup(l1,3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
