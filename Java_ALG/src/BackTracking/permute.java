package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 全排列
 * @author: wangzijin
 * @create: 2024-04-15 19:58
 **/
// https://leetcode.cn/problems/permutations/description/
public class permute {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        permute test = new permute();
        int[] nums = {1, 2, 3};
        System.out.println(test.method(nums));
    }

    void backtracking(int[] nums, boolean[] used) { // 排列问题需要一个used数组, 标记已经选择的元素, 不用使用startIndex
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // path里已经收录的元素, 直接跳过
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> method(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }
}