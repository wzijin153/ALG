package Array;

/**
 * @program: alghorithm
 * @description: 长度最小的子数组
 * @author: wangzijin
 * @create: 2024-02-19 21:52
 **/

// 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0
// 输入：s = 7, nums = [2,3,1,2,4,3]
// 输出：2
// 解释：子数组 [4,3] 是该条件下的长度最小的子数组

public class minSubArrayLen {
    public int method(int[] nums, int s) {
        int left = 0;
        int sum = 0;
        int subLength = Integer.MAX_VALUE; // 正无穷
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while  (sum >= s) {
                subLength = Math.min(subLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return subLength == Integer.MAX_VALUE ? 0 : subLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        minSubArrayLen test = new minSubArrayLen();
        int res = test.method(nums, s);
        System.out.println(res);
    }
}