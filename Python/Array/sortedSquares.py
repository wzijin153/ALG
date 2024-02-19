from typing import List


# 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序

# def sortedSquares(nums):
#     for i in range(len(nums)):
#         nums[i] *= nums[i]
#     return nums.sort()

def sortedSquares(nums: list[int]) -> list[int]:
    i = 0
    j, k = len(nums) - 1, len(nums) - 1
    result = [float('inf')] * len(nums) # float('inf')代表正无穷
    while i <= j:
        if nums[i] * nums[i] > nums[j] * nums[j]:
            result[k] = nums[i] * nums[i]
            i += 1
        else:
            result[k] = nums[j] * nums[j]
            j -= 1
        k -= 1
    return result


# nums = [-4, -1, 0, 3, 10]
nums = [-7, -3, 2, 3, 11]
res = sortedSquares(nums)
print(res)
