package Array;

import static java.util.Collections.reverse;

/**
 * @program: alghorithm
 * @description: 删除有序数组中的重复项
 * @author: wangzijin
 * @create: 2024-03-19 16:11
 **/
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/

/*
    1.slow 走在后面, fast 走在前面探路，找到一个不重复的元素就赋值给 slow, 并让 slow 前进一步
    2.当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是整个数组去重之后的结果
 */
public class removeDuplicates {
    public int method(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
