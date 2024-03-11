package DoublePointer;

/**
 * @program: alghorithm
 * @description: 移动零
 * @author: wangzijin
 * @create: 2024-03-08 15:59
 **/

// https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
public class moveZeroes {
    public void method(int[] nums) {
        // 将所有非零元素移到数组的前面, 参考RemoveElement.java
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        // 将剩余的位置填充为0
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}