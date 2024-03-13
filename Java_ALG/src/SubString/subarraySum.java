package SubString;

import java.util.HashMap;

/**
 * @program: alghorithm
 * @description: 和为 k 的子数组
 * @author: wangzijin
 * @create: 2024-03-12 23:34
 **/

// https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
public class subarraySum {
    public int method(int[] nums, int k) {
        // 使用哈希表记录前缀和及其出现的次数 <前缀和, 次数>
        // TODO 用前缀和当作key就不用考虑nums中具体元素的情况, 简化了问题难度
        HashMap<Integer, Integer> map = new HashMap<>();
        // 前缀和为 0 的次数为 1，表示当元素之前没有元素时，前缀和为 0 的个数为 1
        map.put(0, 1);
        int count = 0; // 记录和为 k 的子数组个数
        int prefixSum = 0; // 记录当前的前缀和
        for (int i : nums) {
            prefixSum += i;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        subarraySum test = new subarraySum();
        test.method(nums, k);
    }
}
