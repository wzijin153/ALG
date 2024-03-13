package HashTable;

import java.util.HashMap;

/**
 * @program: alghorithm
 * @description: 四数相加II
 * @author: wangzijin
 * @create: 2024-03-12 23:34
 **/

// https://leetcode.cn/problems/4sum-ii/
public class fourSumCount {
    public int method(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 将 nums1 和 nums2 中所有元素之和存入哈希表
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        // 在 nums3 和 nums4 中寻找与哈希表中的和相反数的元素
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                // TODO 为什么用contains
                // 因为当前是在遍历nums3和nums4得到c + d和, 然后去map里看是否包含-(c + d), 如果包含则说明存在(a + b + c + d) = 0
                if (map.containsKey(target)) {
                    // 这里count不是直接++, 而是加map中的value, 因为value对应-(c + d)出现过多少次
                    count += map.get(target);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        fourSumCount test = new fourSumCount();
        test.method(nums1, nums2, nums3, nums4);
    }
}