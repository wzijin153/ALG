package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 子集
 * @author: wangzijin
 * @create: 2024-04-14 16:59
 **/

public class subsets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        subsets test = new subsets();
        int[] nums = {1, 2, 3};
        System.out.println(test.method(nums));
    }

    void backtracking(int[] nums, int startIndex) {
        // 不需要终止条件: 每一层的搜索结果都要加入
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
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