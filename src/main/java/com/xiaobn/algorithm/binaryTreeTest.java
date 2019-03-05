package com.xiaobn.algorithm;

/**
 * 二叉树的遍历
 * 先序遍历：遍历顺序规则为【根左右】
 * 中序遍历：遍历顺序规则为【左根右】
 * 后序遍历：遍历顺序规则为【左右根】
 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能：把一个数组的值存入二叉树中，然后进行3种方式的遍历.
 * 构造的二叉树：
 *               1
 *             /   \
 *            2     3
 *           / \   / \
 *          4   5  6  7
 *         / \
 *        8   9
 *  先序遍历：DLR
 *  1 2 4 8 9 5 3 6 7
 *  中序遍历：LDR
 *  8 4 2 9 5 1 6 3 7
 *  后序遍历：LRD
 *  8 9 4 5 2 6 7 3 1
 *  深度优先遍历：从定点v0开始优先找到叶子节点
 *  1 2 4 8 9 5 3 6 7
 *  广度优先遍历：因为它的思想是从一个顶点V0开始，辐射状地优先遍历其周围较广的区域，故得名。
 *  1 2 3 4 5 6 7 8 9
 * @author  Peter.Qiu
 * @version  [Version NO, 2015年4月2日]
 * @see  [Related classes/methods]
 * @since  [product/module version]
 */
public class binaryTreeTest {


    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<Node> nodeList = null;

    /**
     * 内部类：节点
     *
     */
    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    /** 二叉树的每个结点至多仅仅有二棵子树(不存在度大于2的结点)，二叉树的子树有左右之分，次序不能颠倒。
     <BR>
     * 二叉树的第i层至多有2^{i-1}个结点。深度为k的二叉树至多有2^k-1个结点；<BR>
     * 对不论什么一棵二叉树T，假设其终端结点数为n_0，度为2的结点数为n_2。则n_0=n_2+1。<BR>
     *一棵深度为k，且有2^k-1个节点称之为满二叉树；深度为k，有n个节点的二叉树，<BR>
     *当且仅当其每个节点都与深度为k的满二叉树中，序号为1至n的节点相应时。称之为全然二叉树.<BR>
     * @author  Peter.Qiu [Parameters description]
     * @return void [Return type description]
     * @exception throws [Exception] [Exception description]
     * @see [Related classes#Related methods#Related properties]
     */
    public void createTree() {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点依照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:由于最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,假设数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，仅仅是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public  void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，仅仅是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public  void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的。仅仅是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public  void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    /**
     *               1
     *             /   \
     *            2     3
     *           / \   / \
     *          4   5  6  7
     *         / \
     *        8   9
     * 深度优先遍历，相当于先根遍历
     * 採用非递归实现
     * 须要辅助数据结构：栈
     */
    public void depthOrderTraversal(Node root){
        System.out.println("\n深度优先遍历");
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<Node> stack=new ArrayDeque<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            System.out.print(node.data+ " ");
            if(node.rightChild!=null){
                stack.push(node.rightChild);
            }
            if(node.leftChild!=null){
                stack.push(node.leftChild);
            }
        }
        System.out.print("\n");
    }

    /**
     *               1
     *             /   \
     *            2     3
     *           / \   / \
     *          4   5  6  7
     *         / \
     *        8   9
     * 广度优先遍历
     * 採用非递归实现
     * 须要辅助数据结构：队列
     */
    public void levelOrderTraversal(Node root){
        System.out.println("广度优先遍历");
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<Node> queue=new ArrayDeque<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.remove();
            System.out.print(node.data+ " ");
            if(node.leftChild!=null){
                queue.add(node.leftChild);
            }
            if(node.rightChild!=null){
                queue.add(node.rightChild);
            }
        }
        System.out.print("\n");
    }
    /**
     *构造的二叉树：
     *               1
     *             /   \
     *            2     3
     *           / \   / \
     *          4   5  6  7
     *         / \
     *        8   9
     *  先序遍历：DLR
     *	1 2 4 8 9 5 3 6 7
     *  中序遍历：LDR
     *  8 4 2 9 5 1 6 3 7
     *  后序遍历：LRD
     *  8 9 4 5 2 6 7 3 1
     *  深度优先遍历
     *	1 2 4 8 9 5 3 6 7
     *	广度优先遍历
     *	1 2 3 4 5 6 7 8 9
     */
    public static void main(String[] args) {
        binaryTreeTest binTree = new binaryTreeTest();
        binTree.createTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        System.out.println("先序遍历：");
        binTree.preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");//LDR
        binTree.inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");//LRD
        binTree.postOrderTraverse(root);

        binTree.depthOrderTraversal(root);//深度遍历
        binTree.levelOrderTraversal(root);//广度遍历
    }

}

