package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 最大子序和
 * @author: wangzijin
 * @create: 2024-05-15 14:16
 **/

public class maxSubArray {
    public static void main(String[] args) {
        maxSubArray test = new maxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test.method(nums));
    }

    public int method(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int result = nums[0];
        // 1.确定dp数组的含义: dp[i]: 截至下标i的连续子数组的最大和为dp[i]
        int[] dp = new int[length + 1];
        // 2.确定递推公式: dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        // 3.初始化dp数组
        dp[0] = nums[0];
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) {
            /**
             * 1. 延续前面的子序列和
             * 2. 从当前元素开始从头计算
             */
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}