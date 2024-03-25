package StackAndQueue;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 逆波兰表达式求值
 * @author: wangzijin
 * @create: 2024-03-23 16:30
 **/
// https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
public class evalRPN {
    public int method(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // 注意：这里先弹出的是第二个操作数
                // 1.先弹出第2个元素
                int b = Integer.parseInt(stack.pop());
                // 2.再弹出第1个元素
                int a = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a / b));
                        break;
                }
            } else stack.push(s);
        }
        return Integer.parseInt(stack.pop());
    }
}