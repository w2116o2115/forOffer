package com.xbniao.linked;

import static com.xbniao.linked.LinkReverse.pringLinked;

/**
 * 删除链表倒数第 n 个结点   链表长度>=n
 * 使用快慢指针。
 * 快指针比慢指针提前n个单元。当快指针到达单链表尾部时，慢指针指向待删除节点的前节点
 * @Author: Carlos Zhang
 * @Date: 2019/1/21 17:02
 */
public class DeleteNodeOfN {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        pringLinked(n1);
        deleteByN(n1,2);
        pringLinked(n1);
    }

    private static void deleteByN(Node head,int n){
        Node fast = head;
        Node slow = head;
        Node temp = null;
        for (int i = 1;i<n;i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            temp = slow;
            slow = slow.next;
        }
        //删除slow
        temp.next = slow.next;
    }
}
