package Greedy;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 无重叠区间
 * @author: wangzijin
 * @create: 2024-04-22 21:41
 **/
// https://leetcode.cn/problems/non-overlapping-intervals/description/
public class eraseOverlapIntervals {
    public static void main(String[] args) {
        eraseOverlapIntervals test = new eraseOverlapIntervals();
//        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(test.method(intervals));
    }

    public int method(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                result++;
            }
        }
        return result;
    }
}