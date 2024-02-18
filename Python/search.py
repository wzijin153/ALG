# 二分查找
# 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
from typing import List


def binSearch(nums, target):
    left = 0
    right = len(nums) - 1
    while left <= right:
        middle = left + (right - left) // 2
        if nums[middle] < target:
            left = middle + 1
        elif nums[middle] > target:
            right = middle - 1
        else:
            return middle
    return -1


nums = [-1, 0, 3, 5, 9, 12]
target = 9
res = binSearch(nums, target)
print(res)
