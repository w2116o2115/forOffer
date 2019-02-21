package com.xbniao.linked;

/**
 * 链表节点
 * @Author: Carlos Zhang
 * @Date: 2019/1/21 14:01
 */
public class Node {
    int date;
    Node next;

    public Node(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
