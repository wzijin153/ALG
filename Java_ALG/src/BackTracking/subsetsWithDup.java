package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 子集II
 * @author: wangzijin
 * @create: 2024-04-15 19:12
 **/
// https://leetcode.cn/problems/subsets-ii/
public class subsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        subsetsWithDup test = new subsetsWithDup();
        int[] nums = {1, 2, 2};
        System.out.println(test.method(nums));
    }

    void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;// 树层去重, 因为nums中存在重复元素
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> method(int[] nums) {
        Arrays.sort(nums);// 要进行树层去重之前, 一定要对原数组进行排序
        backtracking(nums, 0);
        return result;
    }
}