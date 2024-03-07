package HashTable;

import java.util.HashMap;
/**
 * @program: alghorithm
 * @description: 两数之和
 * @author: wangzijin
 * @create: 2024-03-07 16:32
 **/

// 用 HashMap 求解, 遍历nums, 将nums中的元素以<元素值, 索引>形式存放在 HashMap 中
// 检查(目标值减去当前元素的差)是否在哈希表中
public class TwoSum {
    public int[] method(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {// containsKey: 检查 hashMap 中是否存在指定的 key 对应的映射关系, hashmap.containsKey(Object key)
                return new int[]{map.get(complement), i};// 获取指定 key 对应对 value
            }
            // 将当前元素的值和索引存储在哈希表中
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
