package com.yixin.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 原题链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 * @Author: Carlos Zhang
 * @Date: 2019/3/8 14:12
 */
public class LeetCode117 {
    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //广序优先便利
    public void connect(Node root) {
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.peek();
                q.poll();
                if (i < size - 1) temp.next = q.peek();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }
}
