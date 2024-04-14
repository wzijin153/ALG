package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 组合总和
 * @author: wangzijin
 * @create: 2024-04-14 13:05
 **/
// https://leetcode.cn/problems/combination-sum/description/
public class combinationSum {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum test = new combinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(test.method(candidates, target));
    }

    void backtracking(int[] candidates, int target, int startIndex) {
        // 终止条件
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 单层逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i); // 从i开始表示当前元素可以被重复选取, i + 1表示当前元素不可被重复选取
                path.remove(path.size() - 1); // 回溯: 去掉path中最后一个值, 用索引
            }
        }
    }

    public List<List<Integer>> method(int[] candidates, int target) {
        Arrays.sort(candidates);// 剪枝: 先进行排序
        backtracking(candidates, target, 0);
        return result;
    }
}