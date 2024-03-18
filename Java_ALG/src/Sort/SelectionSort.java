package Sort;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 选择排序
 * @author: wangzijin
 * @create: 2024-03-17 14:12
 **/

/*
    1.在每次遍历的过程中, 都假设第一个索引处的元素为最小值
    2.依次遍历最小值索引后面的数, 取出最小值的索引
    3.第一个索引值和第二个索引值比较, 如果第二个索引的数小于第一个索引的数, 则交换
 */
class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {// 这里的 i 表示选择排序的趟数
            // 假设当前元素为最小值的索引
            int minIndex = i;
            // 在未排序部分中查找最小值的索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小值与当前位置进行交换
            if (array[minIndex] < array[i]) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {64, 25, 12, 22, 11};
        selectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}