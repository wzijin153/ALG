package StackAndQueue;

import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 用栈实现队列
 * @author: wangzijin
 * @create: 2024-03-23 13:23
 **/
//https://leetcode.cn/problems/implement-queue-using-stacks/description/
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     * 初始化
     */
    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    // 将元素 x 推到队列的末尾
    public void push(int x) {
        stackIn.push(x);
    }

    // 从队列的开头移除并返回元素
    public int pop() {
        stackInTostackOut();
        return stackOut.pop();
    }

    // 返回队列开头的元素
    public int peek() {
        stackInTostackOut();
        return stackOut.peek();
    }

    // 如果队列为空，返回 true ；否则，返回 false
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    /*
    1.将stackIn的元素全部弹出, 再依次放入stackOut中
    2.弹出stackOut的第一个元素
     */
    void stackInTostackOut() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}