package Greedy;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 分发饼干
 * @author: wangzijin
 * @create: 2024-04-17 19:38
 **/
// https://leetcode.cn/problems/assign-cookies/description/
public class findContentChildren {
    public static void main(String[] args) {
        findContentChildren test = new findContentChildren();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(test.method(g, s));
    }

    public int method(int[] g, int[] s) {
        // 贪心策略：大饼干给为胃口大的小孩吃
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1;
        // 对小孩胃口数组进行遍历
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) { // 这里用if来循环, 是因为需要控制循环的条件
                result++;
                index--; // 饼干分发成功才会移动下标
            }
        }
        return result;
    }
}