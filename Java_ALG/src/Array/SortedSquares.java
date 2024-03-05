package Array;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 有序数组的平方
 * @author: wangzijin
 * @create: 2024-02-19 20:17
 **/

// 一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序

// 输入：nums = [-4,-1,0,3,10]
// 输出：[0,1,9,16,100]
// 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]

// 输入：nums = [-7,-3,2,3,11]
// 输出：[4,9,9,49,121]

class SortedSquares {
    public int[] method(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
//        return Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SortedSquares test = new SortedSquares();
        int[] res = test.method(nums);
        System.out.println(Arrays.toString(res));
    }
}