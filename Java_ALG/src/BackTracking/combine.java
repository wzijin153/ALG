package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 组合
 * @author: wangzijin
 * @create: 2024-04-07 21:29
 **/
// https://leetcode.cn/problems/combinations/
public class combine {
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    void backtracking(int n, int k, int startIndex) {
        // 终止条件: 到树形结构叶子节点时
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 单层搜索逻辑
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast(); // 回溯
        }
    }

    public List<List<Integer>> method(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
}