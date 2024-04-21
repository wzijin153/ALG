package Greedy;

/**
 * @program: alghorithm
 * @description: 加油站
 * @author: wangzijin
 * @create: 2024-04-21 14:39
 **/
// https://leetcode.cn/problems/gas-station/description/
public class canCompleteCircuit {
    public int method(int[] gas, int[] cost) {
        int start = 0; // 用start作为返回
        int curSum = 0;
        int totalSum = 0; // 统计整体剩余油量的和
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1; // start表示用下一个i作为起点, 这样就不用单独再写逻辑来控制i的遍历
                curSum = 0; // 以下一个元素开始重新计数
            }
        }
        if (totalSum < 0) return -1; // 如果整体剩余油量小于0, 则说明不论从哪里开始, 都不可能跑完一圈
        else return start;
    }
}