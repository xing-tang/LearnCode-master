package com.open.learncode.算法.leetcode_快手;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.ArrayList;

/**
 * 题目：
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 例如二叉树如下：
 * * *****5
 * * *** / \
 * * ***4  8
 * * * /  / \
 * * *11 13 4
 * * / \   / \
 * *7  2  5  1
 * * sum=22
 * <p>
 * 解题思路：
 * 利用辅助栈的特性
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class KS5_二叉树和为某一值的路径 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node5_2 = new TreeNode<Integer>(5);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11, node7, node2);
        TreeNode<Integer> node13 = new TreeNode<Integer>(13);
        TreeNode<Integer> node4_2 = new TreeNode<Integer>(4, node5_2, node1);
        TreeNode<Integer> node4_1 = new TreeNode<Integer>(4, node11, null);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8, node13, node4_2);
        TreeNode<Integer> node5_1 = new TreeNode<Integer>(5, node4_1, node8);

        PrintUtils.getInstance().printIntArrayArrayList(method(node5_1, 22));
    }

    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();


    public static ArrayList<ArrayList<Integer>> method(TreeNode<Integer> root, int target) {
        preOrder(root, target);
        return list;
    }

    private static void preOrder(TreeNode<Integer> root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            list.add(new ArrayList(path));
        preOrder(root.left, target);
        preOrder(root.right, target);
        path.remove(path.size() - 1);
    }
}
