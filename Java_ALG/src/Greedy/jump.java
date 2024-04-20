package Greedy;

/**
 * @program: alghorithm
 * @description: 跳跃游戏 II
 * @author: wangzijin
 * @create: 2024-04-20 10:17
 **/
// https://leetcode.cn/problems/jump-game-ii/
public class jump {
    public static void main(String[] args) {
        jump test = new jump();
        int[] nums = {2, 5, 0, 0, 0};
        System.out.println(test.method(nums));
    }

    public int method(int[] nums) {
        int result = 0;
        int cover = 0;
        int nextCover = 0; // 下一步覆盖范围: 一旦当前覆盖范围没有到终点, 我们就启动下一步覆盖范围
        if (nums.length == 1) return result;
        for (int i = 0; i < nums.length; i++) {
            nextCover = Math.max(nextCover, i + nums[i]); // 每次都寻找当前覆盖范围内最大的元素->能在下一次跳到最远
            if (i == cover && cover < nums.length - 1) { // 如果i走到当前覆盖范围的最大值, 并且还没有到达数组终点时->需要更新覆盖范围了, 也就是需要进行下一次跳跃了
                result++;
                cover = nextCover;
            }
        }
        return result;
    }
}