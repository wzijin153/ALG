# 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
# 输入: 3 输出: [[ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ]]

def generateMatrix(n):
    nums = []
    # start_x, start_y, count = 0, 0, 1
    # for offset in range(1, int(n / 2) + 1):
    #     for j in range(start_y, n - offset):
    #         nums[start_x][j] = count
    #         count += 1
    #     for i in range(start_x, n - offset):
    #         nums[i][j] = count
    #         count += 1
    #     for j in range(n - offset, start_y, -1):
    #         nums[i][j] = count
    #         count += 1
    #     for i in range(n - offset, start_x, -1):
    #         nums[i][j] = count
    #         count += 1
    #     start_x += 1
    #     start_y += 1
    # return nums


if __name__ == '__main__':
    print(generateMatrix(3))
