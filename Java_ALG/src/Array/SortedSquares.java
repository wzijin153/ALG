package Array;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 有序数组的平方
 * @author: wangzijin
 * @create: 2024-02-19 20:17
 **/



public class SortedSquares {
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