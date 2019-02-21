package com.xbniao.linked;

/**
 * 单链表中环的检测
 * 解决思路1：快慢指针法
 * 这是最常见的方法。思路就是有两个指针P1和P2，同时从头结点开始往下遍历链表中的所有节点。
 *
 * P1是慢指针，一次遍历一个节点。
 * P2是快指针，一次遍历两个节点。
 *
 * 如果链表中没有环，P2和P1会先后遍历完所有的节点。
 *
 * 如果链表中有环，P2和P1则会先后进入环中，一直循环，并一定会在在某一次遍历中相遇。
 *
 * 因此，只要发现P2和P1相遇了，就可以判定链表中存在环。
 * @Author: Carlos Zhang
 * @Date: 2019/1/21 15:34
 */
public class IsCircle {
    private static boolean isCircle(Node head){
        if (head == null){
            return false;
        }
        Node p = head;
        Node q = head.next;
        while (q != null && q.next != null){
            p = p.next;
            q = q.next.next;
            if (q == null){
                return false;
            }
            if (p == q){
                return true;
            }
        }
        return false;
    }
}
