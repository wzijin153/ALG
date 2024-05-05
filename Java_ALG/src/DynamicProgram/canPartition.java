package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 分割等和子集
 * @author: wangzijin
 * @create: 2024-05-04 13:39
 **/
// https://leetcode.cn/problems/partition-equal-subset-sum/description/
public class canPartition {
    public boolean method(int[] nums) {
        int length = nums.length;
        if (length == 1) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false; // 总和为奇数，不能平分
        int target = sum / 2;
        // 1.确定dp数组的含义: dp[j]: 容量为j的背包的最大价值为dp[j]
        int[] dp = new int[target + 1]; // 判断容量为target的背包能否装满
        // 2.确定递推公式: dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]), nums[i]既是重量又是价值
        // 3.初始化dp数组, 全部初始化为0
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) return true; // 剪枝: 每一次完成內層的for-loop，立即檢查是否dp[target] == target
        }
        return false;
    }
}