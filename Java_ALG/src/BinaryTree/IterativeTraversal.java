package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: alghorithm
 * @description: 迭代遍历
 * @author: wangzijin
 * @create: 2024-03-24 16:25
 **/

public class IterativeTraversal {
    // 前序遍历, https://leetcode.cn/problems/binary-tree-preorder-traversal/
    // TODO 遍历顺序: 根 -> 左 -> 右
    public List<Integer> method(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        // TODO 入栈顺序: 根 -> 右 -> 左, 出栈顺序: 根 -> 左 -> 右
        // 1.根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // 2.右节点入栈
            if (node.right != null) stack.push(node.right);
            // 3.左节点入栈
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    // 中序遍历, https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
    // TODO 遍历顺序: 左 -> 根 -> 右 (访问顺序与节点处理顺序不一致, 先处理左节点, 再处理右节点)
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                // 1.先处理左节点
                cur = cur.left;
            } else {
                // 先取出被弹出的元素, 不要直接弹出元素然后扔掉, 需要弹出元素的右孩子
                cur = stack.pop();
                res.add(cur.val);
                // 2.再处理右节点
                cur = cur.right;
            }
        }
        return res;
    }

    // 后序遍历, https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
    // TODO 遍历顺序: 左 -> 右 -> 根
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        // TODO 入栈顺序: 根 -> 左 -> 右, 出 栈顺序: 根 -> 右 -> 左
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        // TODO 反转顺序: 左 -> 右 -> 根
        Collections.reverse(res);
        return res;
    }
}