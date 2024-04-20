package Greedy;


/**
 * @program: alghorithm
 * @description: 摆动序列
 * @author: wangzijin
 * @create: 2024-04-19 10:59
 **/
// https://leetcode.cn/problems/wiggle-subsequence/
/*
    1.不需要具体删除元素, 遇到摆动就记录一次
    2.用两个变量来记录当前元素与前一个和后一个元素之间的差值
 */
public class wiggleMaxLength {
    public static void main(String[] args) {
        wiggleMaxLength test = new wiggleMaxLength();
        int[] nums = {0, 0, 0};
        System.out.println(test.method(nums));
    }

    public int method(int[] nums) {
        if (nums.length == 1) return 1;
        int preDiff = 0; // 记录当前元素与前一个元素的坡度差
        int curDiff = 0; // 记录后一个元素与当前元素的坡度差
        int result = 1; // 波动次数
        // 1.先求差值
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if (preDiff >= 0 && curDiff < 0 || preDiff <= 0 && curDiff > 0) {
                result++; // 记录摆动数
                preDiff = curDiff; // curDiff出现摆动时才记录, 这样就避免了记录出现单调有平坡的情况
            }
        }
        return result;
    }
}