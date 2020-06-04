package com.open.learncode.剑指offer.每日回顾.day_01;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * ******1
 * *** /   \
 * ***2     3
 * * / \   / \
 * *4  5  6   7
 * <p>
 * 解题思路：
 * 利用递归、迭代(栈)、Morris方法来打印前中后序遍历
 * 前序遍历: 1 2 4 5 3 6 7
 * 中序遍历: 4 2 5 1 6 3 7
 * 后序遍历: 4 5 2 6 7 3 1
 * <p>
 * 复杂度分析：
 * 递归方法：时间复杂度：O(n)，空间复杂度：O(n)
 * 迭代方法：时间复杂度：O(n)，空间复杂度：O(n)
 * Morris方法：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod7_1 {


    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {

        public E value;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRight(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);


        System.out.print("层序遍历：");
        centerOrder(node1);
        System.out.println();

        System.out.print("递归打印前序遍历: ");
        preOrder_1(node1);
        System.out.println();
        System.out.print("迭代打印前序遍历: ");
        preOrder_2(node1);
        System.out.println();


        System.out.print("递归打印中序遍历: ");
        inOrder_1(node1);
        System.out.println();
        System.out.print("迭代打印中序遍历: ");
        inOrder_2(node1);
        System.out.println();


        System.out.print("递归打印后序遍历: ");
        postOrder_1(node1);
        System.out.println();
        System.out.print("迭代打印后序遍历: ");
        postOrder_2(node1);
        System.out.println();
    }

    private static void postOrder_1(TreeNode<Integer> root) {
        if (root != null) {
            postOrder_1(root.left);
            postOrder_1(root.right);
            System.out.print(root.value + " ");
        }
    }


    private static void postOrder_2(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = root;
        TreeNode<Integer> temp = null;
        stack.push(cur);
        while (!stack.isEmpty()) {
            temp = stack.peek();
            if (temp.left != null && temp.left != cur && temp.right != cur) {
                stack.push(temp.left);
            } else if (temp.right != null && temp.right != cur) {
                stack.push(temp.right);
            } else {
                System.out.print(stack.pop().value + " ");
                cur = temp;
            }
        }
    }

    private static void inOrder_1(TreeNode<Integer> root) {
        if (root != null) {
            inOrder_1(root.left);
            System.out.print(root.value + " ");
            inOrder_1(root.right);
        }
    }

    private static void inOrder_2(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = root;
        TreeNode<Integer> temp = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            temp = stack.pop();
            System.out.print(temp.value + " ");
            if (temp.right != null) {
                cur = temp.right;
            }
        }
    }



    private static void preOrder_1(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder_1(root.left);
            preOrder_1(root.right);
        }
    }

    private static void preOrder_2(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> temp = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.value + " ");
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    private static void centerOrder(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }

    }

}

