package DoublePointer;

/**
 * @program: alghorithm
 * @description: 盛最多水的容器
 * @author: wangzijin
 * @create: 2024-03-08 16:18
 **/

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked

//  1.使用两个指针 left 和 right，分别指向数组的两端
//  2.计算当前容器的容量，即 min(height[left], height[right]) * (right - left)
//  3.移动指针：如果 height[left] < height[right]，则将 left 指针向右移动；否则，将 right 指针向左移动

public class maxArea {
    public int method(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int length = right - left;
            int width = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, length * width);
            // 类似于二分查找的过程
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea test = new maxArea();
        int result = test.method(height);
        System.out.println(result);
    }
}