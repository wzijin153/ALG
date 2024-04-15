package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 递增子序列
 * @author: wangzijin
 * @create: 2024-04-15 19:24
 **/
// https://leetcode.cn/problems/non-decreasing-subsequences/description/
public class findSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        findSubsequences test = new findSubsequences();
        int[] nums = {4, 4, 3, 2, 1};
        System.out.println(test.method(nums));
    }

    void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
            // 注意这里不要加return，因为要取树上的所有节点
        }
        HashSet<Integer> hashSet = new HashSet<>();// 用 HashSet 进行树层去重, 不能取同一层已经取过的数
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.getLast() > nums[i] || hashSet.contains(nums[i])) continue;
            hashSet.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> method(int[] nums) {
        backtracking(nums, 0);
        return result;
    }
}