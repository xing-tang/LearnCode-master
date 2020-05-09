package com.open.learncode.剑指offer;

/**
 * 题目：
 * 把数组排成最小的数：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接处的所有
 * 数字中最下的一个。例如，输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323.
 * <p>
 * 解题思路：
 * 排序规则：若x+y>y+x，则x大于y；若x+y<y+x，则x小于y
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(nlogn)
 * 【】
 * 空间复杂度：O(n)
 * 【】
 */

public class TestMethod45 {

    public static void main(String[] args) {

        int[] nums = {3, 32, 321};
        System.out.println("最小的数为：" + method(nums));

    }

    private static String method(int[] nums) {

        //字符串列表str ，保存各数字的字符串格式
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            str[i] = String.valueOf(nums[i]);

        //对字符串列表进行"排序"
        fastSort(str, 0, str.length - 1);

        StringBuilder res = new StringBuilder();
        for (String s : str)
            res.append(s);

        return res.toString();

    }

    /**
     * 快速排序：修改排序判断规则
     *
     * @param str
     * @param start
     * @param end
     */
    private static void fastSort(String[] str, int start, int end) {

        //鲁棒性
        if (start >= end)
            return;

        int i = start, j = end;
        String temp = str[i];

        while (i < j) {

            while ((str[j] + str[start]).compareTo(str[start] + str[j]) >= 0 && i < j)
                j--;
            while ((str[i] + str[start]).compareTo(str[start] + str[i]) <= 0 && i < j)
                i++;

            temp = str[i];.
            str[i] = str[j];
            str[j] = temp;
        }

        str[i] = str[start];
        str[start] = temp;
        fastSort(str, start, i - 1);
        fastSort(str, i + 1, end);
    }

}