package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: alghorithm
 * @description: 根据身高重建队列
 * @author: wangzijin
 * @create: 2024-04-21 18:20
 **/
//
/*
    1.先按照身高从大到小排序, 身高相同的情况下按照k从小到达排序
 */
public class reconstructQueue {
    public int[][] method(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // a - b 是升序排列, 在身高相同的情况下，按照k升序排列
            return b[0] - a[0]; // b - a 是降序排列
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person); // 插入到下标为k的位置上, 并且是插入到当前节点的前一个节点
        }
        return queue.toArray(new int[][]{});
    }
}