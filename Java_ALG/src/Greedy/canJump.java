package Greedy;

/**
 * @program: alghorithm
 * @description: 跳跃游戏
 * @author: wangzijin
 * @create: 2024-04-19 19:12
 **/
// https://leetcode.cn/problems/jump-game/description/
public class canJump {
    public static void main(String[] args) {
        canJump test = new canJump();
        int[] nums = {2, 5, 0, 0};
        System.out.println(test.method(nums));
    }

    public boolean method(int[] nums) {
        if (nums.length == 1) return true;
        // 不要求具体是如何跳的, 求每个下标元素的最大覆盖范围
        int cover = 0; // 求最大覆盖范围
        for (int i = 0; i <= cover; i++) { // i 一定要在覆盖范围内移动
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}