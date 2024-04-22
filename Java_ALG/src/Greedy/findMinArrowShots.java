package Greedy;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 用最少数量的箭引爆气球
 * @author: wangzijin
 * @create: 2024-04-22 21:16
 **/
// https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
public class findMinArrowShots {
    public int method(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 1; // 第一个气球一定要一个弓箭
        for (int i = 1; i < points.length; i++) {
            // 当前气球的左边界大于前一个气球左边界 -> 两个气球不重叠 -> 需要两只弓箭
            if (points[i][0] > points[i - 1][1]) result++;
                // 实时更新右边界：当前气球的前一个气球是否和当前气球的下一个气球重叠 -> 判断是否出现3个气球重叠的情况
            else points[i][1] = Math.min(points[i - 1][1], points[i][1]);
        }
        return result;
    }
}