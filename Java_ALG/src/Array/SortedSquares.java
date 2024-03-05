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
//        增强型 for 循环 i 是数组 nums 中的元素值, 而不是索引
//        for (int i : nums) {
//            nums[i] = nums[i] * nums[i]; i 不是索引
//            i = i * i; i 是一个临时变量，对其进行操作并不会影响数组中的实际元素
//        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SortedSquares test = new SortedSquares();
        int[] res = test.method(nums);
        System.out.println(Arrays.toString(res));
    }
}