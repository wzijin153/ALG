package DynamicProgram;


/**
 * @program: alghorithm
 * @description: 最长重复子数组
 * @author: wangzijin
 * @create: 2024-05-14 15:03
 **/
// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
public class findLength {
    public int method(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int result = 0;
        // 1.确定dp数组的含义: dp[i][j]: 以i-1结尾的nums1和以j-1结尾的nums2，这两个子数组的最长重复子数组的长度为dp[i][j]
        int[][] dp = new int[length1 + 1][length2 + 1]; // m个0，n个1
        // 2.确定递推公式: if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1]++;
        // 3.初始化dp数组, 全部初始化为0
        // 4.确定遍历顺序
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }
}