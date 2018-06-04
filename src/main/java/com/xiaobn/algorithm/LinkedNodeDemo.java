package com.xiaobn.algorithm;

/**
 * 从表头节点依次遍历，将当前节点的后继指针指向它的前驱节点即可；此时需要prev、next分表记录当前节点的前驱节点和后继节点。
 */
public class LinkedNodeDemo {

    public static void main(String[] args) {

        LinkedNodeDemo demo = new LinkedNodeDemo();
        demo.test();
    }

    public void test(){

        Node<Integer> head = initLinkedList();

        printLinkedList(head);

        System.out.println("**************");

        //反转链表
        Node<Integer> node = reverseLinkedList(head);
        printLinkedList(node);
    }

    /**反转链表**/
    private Node<Integer> reverseLinkedList(Node<Integer> head) {
        if (head == null || head.next==null) {
            return head;
        }

        Node<Integer> prev = null;
        Node<Integer> next = null;
        while(head.next!=null){
            next = head.next;   //保存下一个节点
            head.next = prev;   //重置next
            prev = head;    //保存当前节点
            head = next;
        }
        head.next = prev;
        return head;
    }

    /**初始化链表**/
    private Node<Integer> initLinkedList() {
        Node<Integer> head = new Node<Integer>(0, null);
        Node<Integer> cur = head;
        for(int i = 1; i< 10; i++){
            cur.next = new Node<Integer>(i, null);
            cur = cur.next;
        }
        return head;
    }

    /**打印链表**/
    private void printLinkedList(Node<Integer> head) {
        Node<Integer> node = head;
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**单向链表定义**/
    static class Node<T> {
        private T value;    //节点值
        private Node<T> next;   //后继节点

        public Node() {
        }
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

}