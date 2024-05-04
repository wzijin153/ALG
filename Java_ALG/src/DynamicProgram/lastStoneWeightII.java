package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 最后一块石头的重量II
 * @author: wangzijin
 * @create: 2024-05-04 14:20
 **/
// https://leetcode.cn/problems/last-stone-weight-ii/description/
public class lastStoneWeightII {
    public static void main(String[] args) {
        lastStoneWeightII test = new lastStoneWeightII();
        int[] stones = {31, 26, 33, 21, 40};
        System.out.println(test.method(stones));
//        test.method(stones);
    }

    public int method(int[] stones) {
        int length = stones.length;
        if (length == 1) return stones[0];
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum / 2;
        // 1.确定dp数组的含义: dp[j]: 容量为j的背包的最大价值为dp[j]
        int[] dp = new int[target + 1];
        // 2.确定递推公式: dp[i] = max(dp[j], dp[j - stones[i]] + stones[i]), stones[i]既是重量又是价值
        // 3.初始化dp数组, 全部初始化为0
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}