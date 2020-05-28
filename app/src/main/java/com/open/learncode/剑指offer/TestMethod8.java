package com.open.learncode.剑指offer;

/**
 * 题目：
 * 二叉树的下一个节点：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * 示例：测试b、d、e，分别对应三种情况
 * *****a
 * *** / \
 * ***b   c
 * * /\  / \
 * *d e f  g
 * <p>
 * 解题思路：
 * 分情况找出下一个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod8 {


    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {
        public E value;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针
        public TreeNode parent;//指向该节点的父亲节点

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRightAndParent(TreeNode left, TreeNode right, TreeNode parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }


    public static void main(String[] args) {

        //创建二叉树
        TreeNode<String> nodeA = new TreeNode<String>("a");
        TreeNode<String> nodeB = new TreeNode<String>("b");
        TreeNode<String> nodeC = new TreeNode<String>("c");
        TreeNode<String> nodeD = new TreeNode<String>("d");
        TreeNode<String> nodeE = new TreeNode<String>("e");
        TreeNode<String> nodeF = new TreeNode<String>("f");
        TreeNode<String> nodeG = new TreeNode<String>("g");
        nodeA.setLeftAndRightAndParent(nodeB, nodeC, null);
        nodeB.setLeftAndRightAndParent(nodeD, nodeE, nodeA);
        nodeC.setLeftAndRightAndParent(nodeF, nodeG, nodeA);
        nodeE.setLeftAndRightAndParent(null, null, nodeB);
        nodeD.setLeftAndRightAndParent(null, null, nodeB);
        nodeF.setLeftAndRightAndParent(null, null, nodeC);
        nodeG.setLeftAndRightAndParent(null, null, nodeC);

        method(nodeA);
        method(nodeB);
        method(nodeC);
        method(nodeD);
        method(nodeE);
        method(nodeF);
        method(nodeG);

    }

    /**
     * 找到p节点的下一个节点，分下列几种情况
     * 1、有右子树
     * 2、无右子树 2.1 是其父亲节点的右孩子
     *
     * @param p 给定的一个节点
     * @return
     */
    private static TreeNode method(TreeNode p) {

        //鲁棒性
        if (p == null)
            return null;

        //有右子树：它的下一个节点是其右子树中的最左子节点
        TreeNode cur = p.right;
        if (cur != null) {
            while (cur.left != null) {
                cur = cur.left;
            }
            System.out.println(p.value + "的下一个节点是：" + cur.value);
            return cur;
        }

        //无右子树
        //又分为两种情况：1.该节点是其父亲节点的左孩子，则下一个节点是其父亲节点
        //2.该节点是其父亲节点的右孩子，则不断的回溯找到父亲节点
        TreeNode temp = p;//保存p，用于打印时
        TreeNode parent = p.parent;

        //情况2：①p是parent的右孩子，且是右子树上的右孩子，这时parent==null
        //②p是parent的右孩子，且是左子树上的右孩子，这时parent==root
        while (parent != null && parent.left != p) {
            p = parent;
            parent = p.parent;

        }

        if (parent == null) {
            System.out.println(temp.value + "没有下一个节点");
            return null;
        }

        //情况1：p是parent的左孩子
        System.out.println(temp.value + "的下一个节点是：" + parent.value);
        return parent;


    }
}

