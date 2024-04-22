package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: alghorithm
 * @description: 合并区间
 * @author: wangzijin
 * @create: 2024-04-22 22:56
 **/
// https://leetcode.cn/problems/merge-intervals/description/
public class merge {
    public static void main(String[] args) {
        merge test = new merge();
        int[][] intervals = {{1, 4}, {5, 6}};
        System.out.println(Arrays.deepToString(test.method(intervals)));
    }

    public int[][] method(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.getLast()[1]) {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            } else result.add(intervals[i]);
        }
        return result.toArray(new int[][]{});
    }
}