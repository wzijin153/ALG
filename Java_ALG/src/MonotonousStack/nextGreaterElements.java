package MonotonousStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 下一个更大元素II
 * @author: wangzijin
 * @create: 2024-05-19 17:14
 **/
// https://leetcode.cn/problems/next-greater-element-ii/
public class nextGreaterElements {
    public int[] method(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length * 2; i++) {
            int j = i % length;
            while (!stack.isEmpty() && nums[j] > nums[stack.peek()]) {
                result[stack.peek()] = nums[j];
                stack.pop();
            }
            stack.push(j);
        }
        return result;
    }
}