package Greedy;

/**
 * @program: alghorithm
 * @description: 分发糖果
 * @author: wangzijin
 * @create: 2024-04-21 15:49
 **/
//https://leetcode.cn/problems/candy/
// 不要左边和右边一起比较, 要先比较左边, 再比较右边, 分两次进行!!!
public class candy {
    public static void main(String[] args) {
        candy test = new candy();
        int[] ratings = {1, 3, 2, 2, 1};
        System.out.println(test.method(ratings));
    }

    public int method(int[] ratings) {
        int result = ratings.length;
        int[] candy = new int[ratings.length];
        // 1.右得分比左高, 从左往右遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        // 2.左得分比右高, 从右往左遍历
        for (int i = ratings.length - 2; i >= 0; i--) { // -2代表从倒数第2个元素开始比较
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }
        for (int i : candy) result += i;
        return result;
    }
}