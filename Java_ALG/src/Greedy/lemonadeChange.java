package Greedy;

/**
 * @program: alghorithm
 * @description: 柠檬水找零
 * @author: wangzijin
 * @create: 2024-04-21 17:36
 **/
// https://leetcode.cn/problems/lemonade-change/
/*
    情况一：账单是5，直接收下
    情况二：账单是10，消耗一个5，增加一个10
    情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
 */
public class lemonadeChange {
    public boolean method(int[] bills) {
        int five = 0, ten = 0; // 用变量来记录5元和10元钞票的数量, 不用维护hashmap(不用记录20, 因为20不会用来找零)
        for (int bill : bills) {
            // 情况一：账单是5，直接收下
            if (bill == 5) five++;
            // 情况二：账单是10，消耗一个5，增加一个10
            if (bill == 10) {
                if (five <= 0) return false;
                ten++;
                five--;
            }
            // 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
            if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) five -= 3;
                else return false;
            }
        }
        return true;
    }
}