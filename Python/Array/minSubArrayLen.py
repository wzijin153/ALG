# 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0

def minSubArrayLen(nums, s):
    left = 0
    sum = 0
    result = float('inf')
    for right in range(0, len(nums)):
        sum += nums[right]
        while sum >= s:
            subLength = right - left + 1
            result = min(result, subLength)
            sum -= nums[left]
            left += 1
    if result == float('inf'):
        result = 0
    return result


if __name__ == '__main__':
    nums = [1, 1, 1, 1, 1, 1, 1, 1]
    s = 11
    res = minSubArrayLen(nums, s)
    print(res)
