package HashTable;

import java.util.HashSet;

/**
 * @program: alghorithm
 * @description: 两个数组的交集
 * @author: wangzijin
 * @create: 2024-03-04 23:09
 **/

class intersection {
    public int[] method(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}