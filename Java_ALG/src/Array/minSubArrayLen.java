package Array;

/**
 * @program: alghorithm
 * @description: 长度最小的子数组
 * @author: wangzijin
 * @create: 2024-02-19 21:52
 **/
// https://leetcode.cn/problems/minimum-size-subarray-sum/description/
public class minSubArrayLen {
    public int method(int[] nums, int s) {
        int left = 0;
        int sum = 0;
        int subLength = Integer.MAX_VALUE; // 正无穷
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) { // 这里要用while去判断, 用if的话只会判断一次
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