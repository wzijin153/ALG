package MonotonousStack;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 接雨水
 * @author: wangzijin
 * @create: 2024-05-20 16:25
 **/
// https://leetcode.cn/problems/trapping-rain-water/
public class trap {
    public int method(int[] height) {
        int length = height.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < length; i++) {
            if (height[i] < height[stack.peek()]) stack.push(i);
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int h = Math.min(height[i], height[left]) - height[mid];
                        int w = i - left - 1;
                        int area = h * w;
                        if (area > 0) result += area;
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}