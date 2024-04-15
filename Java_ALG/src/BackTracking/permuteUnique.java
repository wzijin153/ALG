package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 全排列 II
 * @author: wangzijin
 * @create: 2024-04-15 20:21
 **/

public class permuteUnique {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        permuteUnique test = new permuteUnique();
        int[] nums = {1, 2, 3};
        System.out.println(test.method(nums));
    }

    void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
//        1.用HashSet去重
//        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
//            if (used[i] || hashSet.contains(nums[i])) continue;
//            hashSet.add(nums[i]);
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue; // 树层去重: used[i - 1] == false, 说明同⼀树层nums[i - 1]使⽤过
            if (used[i]) continue; // 常规排列剪枝
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