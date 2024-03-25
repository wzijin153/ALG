package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: alghorithm
 * @description: 前 k 个高频元素
 * @author: wangzijin
 * @create: 2024-03-24 13:26
 **/

public class topKFrequent {
    public int[] method(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 用小顶堆, 从小到大排序, 只需要维持k个元素有序
        // 大顶堆需要对所有元素进行排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 队未满，直接入队
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (entry.getValue() > queue.peek()[1]) {// 当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                queue.poll();// 弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] res = new int[k];
        // 倒序遍历数组
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}