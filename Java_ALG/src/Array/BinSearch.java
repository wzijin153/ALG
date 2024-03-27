package Array;
import java.util.HashSet;
// 二分查找 https://leetcode.cn/problems/binary-search/description/
// 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1

//输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4


class BinSearch {
    public int search(int[] nums, int target){
        if (target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
//            int middle = (left + right) / 2;
            int middle = (left + right) >>> 1;
            if (nums[middle] < target){
                left = middle + 1;
            }else if (nums[middle] > target){
                right = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinSearch binSearch = new BinSearch();
        int res = binSearch.search(nums, target);
        System.out.println(res);
        HashSet<Integer> integers = new HashSet<>();
    }
}
