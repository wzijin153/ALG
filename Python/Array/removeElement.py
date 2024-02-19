# 数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度

# 双指针法
def delete(nums, val):
    slow = 0
    for fast in range(0, len(nums)):
        if nums[fast] != val:
            nums[slow] = nums[fast]
            slow += 1
        fast += 1
    return slow


nums = [3, 2, 2, 3]
val = 3
res = delete(nums, val)
print(res)

nums = [0, 1, 2, 2, 3, 0, 4, 2]
val = 2
res = delete(nums, val)
print(res)
