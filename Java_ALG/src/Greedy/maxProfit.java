package Greedy;

/**
 * @program: alghorithm
 * @description: 买卖股票的最佳时机 II
 * @author: wangzijin
 * @create: 2024-04-19 18:58
 **/
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
public class maxProfit {
    public static void main(String[] args) {
        maxProfit test = new maxProfit();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(test.method(prices));
    }

    public int method(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只需要收集正利润
            if (prices[i] - prices[i - 1] > 0) result += prices[i] - prices[i - 1];
        }
        return result;
    }
}