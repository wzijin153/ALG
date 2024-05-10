package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 打家劫舍II
 * @author: wangzijin
 * @create: 2024-05-08 14:29
 **/

public class rob2 {
    public static void main(String[] args) {
        rob2 test = new rob2();
        int[] nums = {1, 2, 3, 1};
        System.out.println(test.method(nums));
    }

    public int method(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        return Math.max(robAction(nums, 0, length - 1), robAction(nums, 1, length));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}