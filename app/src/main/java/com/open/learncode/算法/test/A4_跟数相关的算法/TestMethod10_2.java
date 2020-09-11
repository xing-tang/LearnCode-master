package com.open.learncode.算法.test.A4_跟数相关的算法;

/**
 * 题目：
 * 青蛙🐸跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上有个n级的台阶总共有多少种跳法
 * <p>
 * 解题思路：
 * 当n=1，只有一种跳法
 * 当n=2，有两种跳法：一次跳2级；分两次跳，一次跳一级
 * 当n>2，第一次跳有两种不同的跳法：
 * 第一次只跳1级，此时，跳法数目=剩下的n-1级台阶的跳法数目，为f(n-1)
 * 第一次跳2级，此时，跳法数目=剩下的n-2级台阶的跳法数目，为f(n-2)
 * 因此，n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2)
 * <p>
 * 实际上，这就是斐波那契数列
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod10_2 {

    public static void main(String[] args) {
        System.out.println(method(5));
    }

    /**
     * 循环，从下往上计算
     *
     * @param n 输入的参数
     * @return 返回斐波那契数列的第n项
     */
    private static long method(int n) {
        if (n <= 2) return n;

        int current = 0;
        int prev1 = 2;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}

