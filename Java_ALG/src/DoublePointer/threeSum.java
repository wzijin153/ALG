package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 三数之和
 * @author: wangzijin
 * @create: 2024-03-08 20:23
 **/

// https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
/*
思考三个问题：
    1.为什么使用target
    2.为什么sum == target就添加到结果中
    3.为什么不要重复元素
 */
public class threeSum {
    public List<List<Integer>> method(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1.对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {// i < nums.length - 2是因为后面会用到left和right指针, 要保证nums[left]和nums[right]不为null
            // 避免重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;// left指向i的下一个
            int right = nums.length - 1;// right指向数组右端
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {// sum == target -> nums[left] + nums[right] == -nums[i] -> nums[i] + nums[left] + nums[right] == 0, 满足题中条件
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < target) {// 使用sum < target是因为nums是排序后的数组
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum test = new threeSum();
        System.out.println(test.method(nums));
    }
}