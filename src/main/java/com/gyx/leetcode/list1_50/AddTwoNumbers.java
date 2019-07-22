package com.gyx.leetcode.list1_50;

import com.gyx.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //获取字符串
        StringBuffer sb1 = new StringBuffer();
        String il1 = listNodeToInt(l1, sb1);
        StringBuffer sb2 = new StringBuffer();
        String il2 = listNodeToInt(l2, sb2);
        //相加
        String add = arrayFormat(multi(il1, il2));
        //分解成ListNode
        char[] chars = add.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char c : chars) {
            String s = String.valueOf(c);
            list.add(Integer.valueOf(s));
        }
        Iterator<Integer> iterator = list.iterator();
        return intToListNode(iterator, null);
    }

    public ListNode intToListNode(Iterator<Integer> iterator, ListNode listNode) {
        if (iterator.hasNext()) {
            ListNode node = new ListNode(iterator.next());
            node.next = listNode;
            return intToListNode(iterator, node);
        } else {
            return listNode;
        }
    }

    public String listNodeToInt(ListNode listNode, StringBuffer sb) {
        int val = listNode.val;
        sb.insert(0,val);
        ListNode next = listNode.next;
        if (next == null) {
            return sb.toString();
        } else {
            return listNodeToInt(next, sb);
        }
    }

    public static int[] multi(String str1, String str2) {
        //将接收到的字符串转化成倒序的char数组
        char[] nums1 = new StringBuffer(str1).reverse().toString().toCharArray();
        char[] nums2 = new StringBuffer(str2).reverse().toString().toCharArray();

        //预先声明一个数组，用来存放各个位数相乘的结果(相似于列竖式)
        int forNum = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] array = new int[forNum];

        //模拟竖式计算

        for (int i = 0; i < forNum; i++) {
            String num1 = "0";
            if (nums2.length > i) {
                num1 = String.valueOf(nums2[i]);
            }
            String num2 = "0";
            if (nums1.length > i) {
                num2 = String.valueOf(nums1[i]);
            }
            array[forNum - 1 - (i)] += Integer.parseInt(num1) + Integer.parseInt(num2);
        }
        return array;
    }

    //对数组进行进位操作。以字符串的形式返回终于结果
    public static String arrayFormat(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            array[i - 1] += array[i] / 10;
            array[i] = array[i] % 10;
        }
        StringBuffer buffer = new StringBuffer();
        if (array[0] != 0) {
            buffer.append(array[0]);
        }
        for (int i = 1; i < array.length; i++) {
            buffer.append(array[i]);
        }
        if ("".equals(buffer.toString())&& array.length == 1 && array[0] == 0){
            return "0";
        }
        return buffer.toString();
    }
}
