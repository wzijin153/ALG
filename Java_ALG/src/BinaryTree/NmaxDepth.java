package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: N叉树的最大深度
 * @author: wangzijin
 * @create: 2024-03-25 15:16
 **/
// https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NmaxDepth {
    public int maxDepth(Node root) {
        // 1.迭代法
        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        if (root == null) return depth;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            // 要用两层循环
            for (int j = 0; j < size; j++) {
                Node node = queue.poll();
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null) queue.offer(node.children.get(i));
                }
            }
        }
        return depth;
        // return getMaxDepth(root);
    }

    // 2.递归法
    int getMaxDepth(Node node) {
        if (node == null) return 0;
        int depth = 0;
        for (int i = 0; i < node.children.size(); i++) {
            depth = Math.max(depth, getMaxDepth(node.children.get(i)));
        }
        return depth + 1;
    }
}
