package StackAndQueue;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 有效的括号
 * @author: wangzijin
 * @create: 2024-03-23 14:53
 **/

public class isValid {
    public boolean method(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<String> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 遇到左括号, 就将对应的右括号压入栈中
            if (ch == '(') stack.push(")");
            else if (ch == '{') stack.push("}");
            else if (ch == '[') stack.push("]");
                // 这里的ch是Char类型, 要和string类型比较, 要先转换类型
            else if (stack.isEmpty() || !stack.peek().equals(String.valueOf(ch))) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}