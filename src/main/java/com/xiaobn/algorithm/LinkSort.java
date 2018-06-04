package com.xiaobn.algorithm;

/**
 * 合并两个有序链表
 */
public class LinkSort {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);    // 指向新链表的头结点的虚头结点，方便最后的返回
        ListNode tempNode = null;   // 排序链表中的前锋指针，指向新链表的最后一个元素。

        // 判断是否为null
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 判断开头
        if (list1.val <= list2.val) {
            head.next = list1;
            list1 = list1.next;
        } else {
            head.next = list2;
            list2 = list2.next;
        }
        tempNode = head.next;

        // 该while 外层循环一直执行的前提，在于两个链表都没有循环到各自最后的null
        while (true) {

            // list1不为空，且值不大于list2的值
            while (list1 != null && list1.val <= list2.val) {
                tempNode.next = list1;
                tempNode = list1;
                list1 = list1.next;
            }
            // 如果list1循环完了，那就直接退出
            if (list1 == null) {
                break;
            }

            while (list2 != null && list2.val <= list1.val) {
                tempNode.next = list2;
                tempNode = list2;
                list2 = list2.next;
            }
            if (list2 == null) {
                break;
            }
        }
        // 把剩余的那部分统一拼接到最后
        if (list1 == null) {
            tempNode.next = list2;
        } else {
            tempNode.next = list1;
        }

        return head.next;
    }
}
