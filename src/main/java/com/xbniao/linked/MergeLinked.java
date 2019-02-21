package com.xbniao.linked;

import static com.xbniao.linked.LinkReverse.pringLinked;

/**
 * 合并两个有序链表
 * @Author: Carlos Zhang
 * @Date: 2019/1/21 16:39
 */
public class MergeLinked {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node x1 = new Node(2);
        Node x2 = new Node(4);
        Node x3 = new Node(6);
        Node x4 = new Node(8);
        Node x5 = new Node(10);
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;

        pringLinked(mergeTwoLists(x1,n1));
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        // 类似归并排序中的合并过程
        Node dummyHead = new Node(0);
        Node cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.date < l2.date) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}
