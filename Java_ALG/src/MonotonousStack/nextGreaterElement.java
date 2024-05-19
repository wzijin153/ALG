package MonotonousStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 下一个更大元素 I
 * @author: wangzijin
 * @create: 2024-05-19 16:04
 **/
// https://leetcode.cn/problems/next-greater-element-i/
public class nextGreaterElement {
    public int[] method(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length1; i++) map.put(nums1[i], i);
        stack.push(0);
        for (int i = 1; i < length2; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                if (map.containsKey(nums2[stack.peek()])) {
                    Integer index = map.get(nums2[stack.peek()]);
                    result[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}