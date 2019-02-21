package com.xbniao.linked;

import static com.xbniao.linked.LinkReverse.pringLinked;

/**
 * 求链表的中间结点
 * 使用快慢指针，一个指针每次只遍历一个节点，另一个速度为2倍，当快指针指向表尾时，慢指针指向中间节点
 * @Author: Carlos Zhang
 * @Date: 2019/1/21 17:54
 */
public class MiddleNodeOfLinked {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        pringLinked(n1);
        Node middle =  findMiddle(n1);
        System.out.println(middle.date);
    }

    private static Node findMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
