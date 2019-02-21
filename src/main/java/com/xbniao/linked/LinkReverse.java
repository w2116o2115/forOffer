package com.xbniao.linked;

/**
 * 链表反转
 * @Author: Carlos Zhang
 * @Date: 2019/1/21 13:59
 */
public class LinkReverse {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        pringLinked(n1);
        System.out.println("=================");
        reverse(n1);
        pringLinked(n4);
    }

    private static Node reverse(Node current){
        if (current == null || current.next == null)
            return current;
        Node nextNode = reverse(current.next);//这其实就是保存下一个节点 一直找到最后节点
        nextNode.next = current;
        current.next = null;
        return current;
    }

    public static void pringLinked(Node head){
        if (head != null){
            System.out.println(head.date);
            if (head.next != null)
                pringLinked(head.next);
        }
    }
}
