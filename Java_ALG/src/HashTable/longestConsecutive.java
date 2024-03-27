package HashTable;

import java.util.HashSet;

/**
 * @program: alghorithm
 * @description: 最长连续序列
 * @author: wangzijin
 * @create: 2024-03-08 11:57
 **/

// https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
//
public class longestConsecutive {
    public int method(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 用HashSet去重, 这样当nums中存在重复数据时就不用再判断
        HashSet<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        int maxLength = 0;
        for (int num : numSet) {
            // 如果num是一个序列的起点，即num-1不在numSet中
            if (!numSet.contains(num - 1)) {
                // 更新序列长度
                int currentNum = num;
                int currentLength = 1;
                // 寻找以当前num为起点的连续序列的长度
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        longestConsecutive test = new longestConsecutive();
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(test.method(nums));
    }
}
