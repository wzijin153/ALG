package Array;

/**
 * @program: alghorithm
 * @description: 最大子数组和
 * @author: wangzijin
 * @create: 2024-03-20 21:39
 **/

public class maxSubArray {
    public int method(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int currentMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}