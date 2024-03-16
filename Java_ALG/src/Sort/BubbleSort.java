package Sort;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 冒泡排序
 * @author: wangzijin
 * @create: 2024-03-16 16:14
 **/

/*
    1.相邻的数据两两交换位置: 大的放后面, 小的放前面
    2.假设数组的长度为n, 冒泡排序最少要比较n -1轮
    3.每次比较的时候, 不用再比较已经排好序的数(在数组的最后)
 */
// 动画演示: https://www.runoob.com/w3cnote/bubble-sort.html
class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {9, 7, 8, 5, 6, 4, 3, 8, 1, 0};
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1 - i; i++) {
                bubbleSort.swap(array, array[i], array[i + 1]);
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void swap(int[] array, int i, int j) {
        if (array[i] > array[j]) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}