package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 组合总和III
 * @author: wangzijin
 * @create: 2024-04-11 20:18
 **/
// https://leetcode.cn/problems/combination-sum-iii/
public class combinationSum3 {
    ArrayList<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    void backtracking(int n, int k, int sum, int startIndex) {
        // 剪枝
        if (sum > n) return;// 如果不加sum剪枝, 会栈溢出
        // 终止条件
        if (path.size() == k) {
            if (sum == n) result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(n, k, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public List<List<Integer>> method(int k, int n) {
        backtracking(n, k, 0, 1);
        return result;
    }
}