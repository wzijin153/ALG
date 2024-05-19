package MonotonousStack;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 每日温度
 * @author: wangzijin
 * @create: 2024-05-19 15:07
 **/
// https://leetcode.cn/problems/daily-temperatures/
public class dailyTemperatures {
    public int[] method(int[] temperatures) {
        /**
         * 递增单调栈: 求一个元素右边第一个更大的元素
         * 递减单调栈: 求一个元素右边第一个更小的元素
         * 遍历时分3种情况:
         *   1.当前遍历的元素 T[i] 小于栈顶元素 T[st.top()]
         *   2.当前遍历的元素 T[i] 等于栈顶元素 T[st.top()]
         *   3.当前遍历的元素 T[i] 大于栈顶元素 T[st.top()]
         */
        int length = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[length];
        stack.push(0);
        for (int i = 1; i < length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) stack.push(i);
            else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) { // 用while代表持续比较, 注意if和while的区别!!!
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}