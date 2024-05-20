package MonotonousStack;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 柱状图中最大的矩形
 * @author: wangzijin
 * @create: 2024-05-20 17:00
 **/
// https://leetcode.cn/problems/largest-rectangle-in-histogram/
public class largestRectangleArea {
    public static void main(String[] args) {
        largestRectangleArea test = new largestRectangleArea();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(test.method(heights));
    }

    public int method(int[] heights) {
        int lengthAdd = heights.length;
        // 数组扩容, 首尾加0
        int[] heightAdd = new int[lengthAdd + 2];
        for (int i = 0; i < lengthAdd; i++) heightAdd[i + 1] = heights[i];
        heights = heightAdd;
        int length = heights.length;
        // 初始化
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < length; i++) {
            if (heights[i] > heights[stack.peek()]) stack.push(i);
            else if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int h = heights[mid];
                        int w = i - left - 1;
                        result = Math.max(result, h * w);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}