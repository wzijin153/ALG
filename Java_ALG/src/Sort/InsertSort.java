package Sort;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 插入排序
 * @author: wangzijin
 * @create: 2024-03-19 13:19
 **/

/*
    1.把所有元素分为两组, 已经排好序的未排序的
    2.找到未排序部分的第一个元素, 向已排序的组中进行插入
    3.倒序遍历已排序的数组, 依次和待插入的元素进行比较, 直到找到一个元素小于待插入元素, 将待插入元素放入该位置, 其他的元素后移一位
 */
public class InsertSort {
    public void sort(int[] nums) {
        // for 循环是寻找未排序部分的第一个元素, 用 i 代表未排序部分的第一个元素的索引值
        for (int i = 1; i < nums.length; i++) {// 这里 i 从1开始是因为, 默认数组第一个索引处的值是排好序的(num[0])
            // 获取当前待插入的元素值
            int curNum = nums[i];
            // 获取待插入位置的前一个元素(已经排序好序)
            int pre = i - 1;
            // 倒序遍历已经排好序的数组
            while (pre >= 0 && nums[pre] > curNum) {
                // 将较大的元素向后移动
                nums[pre + 1] = nums[pre];
                pre--;
            }
            // 插入待排序元素
            nums[pre + 1] = curNum;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] nums = {12, 11, 13, 5, 6};
        insertSort.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
