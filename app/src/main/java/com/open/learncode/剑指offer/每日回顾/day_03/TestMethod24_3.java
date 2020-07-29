package com.open.learncode.剑指offer.每日回顾.day_03;


/**
 * 题目：
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。说明：0 ≤ k 。
 * 例如：
 * ==================================
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * ==================================
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * ==================================
 * <p>
 * 解题思路：
 * 首先将链表闭合成环，然后找到相应的位置断开这个环，确定新的链表头和链表尾。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod24_3 {

    public static class ListNode<E> {
        public E value;
        public ListNode<E> next;

        public ListNode(E value) {
            this.value = value;
        }

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        System.out.print("旋转前的链表：");
        print(node1);
        System.out.print("旋转后的链表：");
        print(method(node1, 2));
    }

    /**
     * 旋转链表
     *
     * @param head 链表节点
     * @param k    右移位数
     * @return 返回链表的头结点
     */
    public static ListNode<Integer> method(ListNode<Integer> head, int k) {
        return null;
    }

    /**
     * 打印链表
     *
     * @param head 头结点
     */
    private static void print(ListNode head) {
        if (head == null) return;
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.value);
                break;
            }
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}