package BinaryTree;

/**
 * @program: alghorithm
 * @description: 把二叉搜索树转换为累加树
 * @author: wangzijin
 * @create: 2024-04-07 20:07
 **/

public class convertBST {
    int pre = 0; // 记录前一个节点的数值, 不是记录前一个节点

    public TreeNode method(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode cur) {
        if (cur == null) return;
        // 右
        traverse(cur.right);
        // 中
        cur.val += pre;
        pre = cur.val;
        // 左
        traverse(cur.left);
    }
}