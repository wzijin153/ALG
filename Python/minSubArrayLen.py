
# 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0

def minSubArrayLen(nums, s):
    i = 0
    sum = 0
    result = float('inf')
    for j in range(0, len(nums)):
        sum += nums[j]
        while sum >= s:
            subLength = j - i + 1
            result = min(result, subLength)
            sum -= nums[i]
            i += 1
    return result


if __name__ == '__main__':
    nums = [2, 3, 1, 2, 4, 3]
    s = 7
    res = minSubArrayLen(nums, s)
    print(res)