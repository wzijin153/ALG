package Skill;

/**
 * @program: alghorithm
 * @description: 只出现一次的数II
 * @author: wangzijin
 * @create: 2024-03-07 16:32
 **/

public class singleNumber {
    public int method(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;// ^: 进行异或运算(XOR), 进行异或计算前会把数值都转换为二进制
        }
        return result;
    }

    public static void main(String[] args) {
        singleNumber test = new singleNumber();
        int[] nums = {4, 2, 1, 2, 1};
        int res = test.method(nums);
        System.out.println(res);
    }
}
