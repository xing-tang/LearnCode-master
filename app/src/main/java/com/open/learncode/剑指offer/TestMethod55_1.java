package com.open.learncode.剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 * * *****1
 * * *** / \
 * * ***2   3
 * * * / \   \
 * * *4  5   6
 * * *  /
 * * * 7
 * <p>
 * 解题思路：
 * 递归、层序遍历
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度 O(n)，空间复杂度：O(n)【最差情况下（当树退化为链表时）】
 * 方法二：时间复杂度 O(n)，空间复杂度：O(n)【最差情况下（当树平衡时）】
 */
public class TestMethod55_1 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5, node7, null);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, null, node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node4, node5);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1, node2, node3);

        System.out.println(method_1(node1));
        System.out.println(method_2(node1));
    }

    /**
     * 递归方法
     *
     * @param root 根节点
     * @return 返回树的深度
     */
    public static int method_1(TreeNode<Integer> root) {
        if (root == null) return 0;
        int left = method_1(root.left);
        int right = method_1(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }

    /**
     * 层序遍历方法
     *
     * @param root 根节点
     * @return 返回树的深度
     */
    public static int method_2(final TreeNode<Integer> root) {
        if (root == null) return 0;
        List<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            List<TreeNode<Integer>> tempQueue = new LinkedList<TreeNode<Integer>>();
            for (TreeNode node : queue) {
                if (node.left != null) tempQueue.add(node.left);
                if (node.right != null) tempQueue.add(node.right);
            }
            queue = tempQueue;
            res++;
        }
        return res;
    }


    public static class TreeNode<E> {

        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
