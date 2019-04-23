package com.yixin.leetcode;

import com.xiaobn.algorithm.LinkSort;
import com.xiaobn.algorithm.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author: Carlos Zhang
 * @Date: 2019/4/23 10:14
 */
public class LeetCode2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        node1.next = node2;
        ListNode node4 = new ListNode(0);
        ListNode node = addTwoNumbers(node1,node4);
        System.out.println(1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode(0);
        ListNode first = new ListNode(0);
        first.next = curNode;
        boolean flag = false;
        if ((l1.val + l2.val) >= 10){
            curNode.val = ((l1.val + l2.val) % 10);
            flag = true;
        }else {
            curNode.val = (l1.val + l2.val);
        }
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 !=null){
            ListNode node = new ListNode(0);
            int  num1 = l1!=null ? l1.val:0;
            int  num2 = l2!=null ? l2.val:0;
            int num = flag ? num1 + num2 + 1 : num1 + num2;
            if (num >= 10){
                node.val = num % 10;
                flag = true;
            }else {
                node.val = num;
                flag = false;
            }
            curNode.next = node;
            curNode = node;
            l1 = l1 !=null ? l1.next : null;
            l2 = l2 !=null ? l2.next : null;
        }
        if (flag){
            curNode.next = new ListNode(1);
        }
        return first.next;
    }
}
