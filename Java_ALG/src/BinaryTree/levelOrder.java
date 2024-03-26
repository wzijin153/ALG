package BinaryTree;

import java.lang.reflect.WildcardType;
import java.util.*;

/**
 * @program: alghorithm
 * @description: 层序遍历
 * @author: wangzijin
 * @create: 2024-03-26 12:39
 **/
// https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class levelOrder {
    public List<List<Integer>> method(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        else queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
