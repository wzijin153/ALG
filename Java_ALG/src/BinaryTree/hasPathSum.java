package BinaryTree;

/**
 * @program: alghorithm
 * @description: 路径总和
 * @author: wangzijin
 * @create: 2024-03-30 22:09
 **/
// https://leetcode.cn/problems/path-sum/
public class hasPathSum {
    public boolean method(TreeNode root, int targetSum) {
        if (root == null) return false;
        // 传入参数的时候，需要减去root.val
        targetSum -= root.val;
        return traversal(root, targetSum);
    }

    /*
    1.不需要遍历整颗树, 遇到符合条件的结果就返回
    2.不要去累加然后判断是否等于目标和, 让计数器count初始为目标和，然后每次减去遍历路径节点上的数值, 如果最后count == 0, 同时到了叶子节点的话, 说明找到了目标和
    3.中节点没有理逻辑时不需要考虑遍历顺序
     */
    boolean traversal(TreeNode node, int target) {
        if (node == null) return false;
        // 终止条件
        if (node.left == null && node.right == null && target == 0) return true;// 遍历到根节点
        if (node.left == null && node.right == null && target != 0) return false;
        // 中间处理逻辑
        if (node.left != null) {
            target -= node.left.val;// 这里target减去的是当前节点的左节点的值, 不是当前节点的值
            if (traversal(node.left, target)) return true;
            target += node.left.val;// 回溯
        }
        if (node.right != null) {
            target -= node.right.val;
            if (traversal(node.right, target)) return true;
            target += node.right.val;// 回溯
        }
        return false;
    }
}