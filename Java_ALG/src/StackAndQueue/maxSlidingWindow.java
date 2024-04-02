package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: alghorithm
 * @description: 滑动窗口最大值
 * @author: wangzijin
 * @create: 2024-03-23 16:50
 **/

public class maxSlidingWindow {
    public static void main(String[] args) {
        maxSlidingWindow test = new maxSlidingWindow();
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        int k = 5;
        test.method(nums, k);
    }

    public int[] method(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

        }
        // 超时
//        int[] res = new int[nums.length - k + 1];
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i <= nums.length - k; i++) {
//            for (int j = i; j < i + k; j++) {
//                queue.offer(nums[j]);
//            }
//            res[i] = queue.poll();
//            // 移除窗口最左侧的元素
//            queue.clear();
//        }
        return res;
    }
}