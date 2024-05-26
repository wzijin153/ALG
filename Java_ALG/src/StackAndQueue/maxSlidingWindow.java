package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: alghorithm
 * @description: 滑动窗口最大值
 * @author: wangzijin
 * @create: 2024-03-23 16:50
 **/
// https://leetcode.cn/problems/sliding-window-maximum/
public class maxSlidingWindow {
    Deque<Integer> deque = new LinkedList<>();

    public int[] method(int[] nums, int k) {
        // 维护单调递减队列出口处的最大值
        if (nums.length == 1) return nums;
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < deque.getLast()) deque.addLast(nums[i]);

        }
        return res;
    }

    void pop(int val) {
        if (!deque.isEmpty() && val == deque.getFirst()) {
            deque.pollFirst();
        }
    }

    void push(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.pollFirst();
        }
        deque.addLast(val);
    }

    int getMaxValue() {
        return deque.getFirst();
    }
}