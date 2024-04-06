package BinaryTree;

import java.util.ArrayList;

/**
 * @program: alghorithm
 * @description: 二叉搜索树中的众数
 * @author: wangzijin
 * @create: 2024-04-03 21:58
 **/
// https://leetcode.cn/problems/find-mode-in-binary-search-tree/
/*
    二叉搜索树一定要中序遍历 -> 产生有序数组
 */
public class findMode {
    TreeNode pre = null;
    int count = 0; // 统计单个元素出现的频率
    int maxCount = 0; // 元素出现的最高频率
    ArrayList<Integer> resList;

    public int[] method(TreeNode root) {
        resList = new ArrayList<>();
        traverse(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    void traverse(TreeNode cur) {
        if (cur == null) return;
        // 左
        traverse(cur.left);
        // 中
        if (pre == null || pre.val != cur.val) count = 1;
        else count++;
        pre = cur;
        if (count == maxCount) resList.add(cur.val);
        // 实时更新result, 只需要遍历一遍二叉树
        if (count > maxCount) {
            // 更新最大值
            maxCount = count;
            resList.clear(); // 将原count值对应的元素清空, 因为最大频率已经更新
            resList.add(cur.val);// 将新maxCount对应的val放入res中
        }
        // 右
        traverse(cur.right);
    }
}