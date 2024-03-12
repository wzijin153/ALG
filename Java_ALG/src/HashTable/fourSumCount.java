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
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}