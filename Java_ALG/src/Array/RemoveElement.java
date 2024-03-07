package Array;

// 移除元素 https://leetcode.cn/problems/remove-element/description/
// 一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
// 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素
// 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] != val){
                // 由于数组元素在内存中是连续存放的, 不能直接移除元素, 所以考虑用双指针法来覆盖元素
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
//        int [] nums = {3, 2, 2, 3};
        int [] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        RemoveElement test = new RemoveElement();
        int res = test.removeElement(nums, val);
        System.out.println(res);
    }
}
