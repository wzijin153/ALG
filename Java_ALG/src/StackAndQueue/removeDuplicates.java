package StackAndQueue;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 删除字符串中的所有相邻重复项
 * @author: wangzijin
 * @create: 2024-03-23 15:33
 **/
// https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
public class removeDuplicates {
    public String method(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) stack.push(s.charAt(i));
            else stack.pop();
        }
        String res = "";
        while (!stack.isEmpty()) res = stack.pop() + res;
        return res;
    }
}