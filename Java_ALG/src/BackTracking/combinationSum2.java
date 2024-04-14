package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 组合总和II
 * @author: wangzijin
 * @create: 2024-04-14 13:48
 **/
// https://leetcode.cn/problems/combination-sum-ii/
public class combinationSum2 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum2 test = new combinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(test.method(candidates, target));
    }

    void backtracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue; // 树层去重: 要对同一树层使用过的元素进行跳过
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);// i+1: 每个数字在每个组合中只能使用一次
            path.removeLast();
        }
    }

    public List<List<Integer>> method(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }
}