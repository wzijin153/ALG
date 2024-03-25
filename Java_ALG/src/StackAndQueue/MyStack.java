package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: alghorithm
 * @description: 用队列实现栈
 * @author: wangzijin
 * @create: 2024-03-23 13:57
 **/
//https://leetcode.cn/problems/implement-stack-using-queues/
public class MyStack {
    // 用双端队列模拟
    Deque<Integer> deque;

    public MyStack() {
        deque = new ArrayDeque<>();
    }

    // 将元素 x 压入栈顶
    public void push(int x) {
        deque.addLast(x);
    }

    // 移除并返回栈顶元素
    public int pop() {
//        return deque.removeLast();
        int size = deque.size();
        size--;
        while (size-- > 0) {
            deque.addLast(deque.peekFirst());
            deque.pollFirst();
        }
        return deque.pollFirst();
    }

    // 返回栈顶元素
    public int top() {
        return deque.peekLast();
    }

    //  如果栈是空的，返回 true ；否则，返回 false
    public boolean empty() {
        return deque.isEmpty();
    }
}