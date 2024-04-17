package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: alghorithm
 * @description: N皇后
 * @author: wangzijin
 * @create: 2024-04-16 19:47
 **/
// https://leetcode.cn/problems/n-queens/
public class solveNQueens {
    List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        solveNQueens test = new solveNQueens();
        int n = 4;
        System.out.println(test.method(n));
    }

    boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查行
        for (int i = 0; i < col; i++) {
            if (chessboard[row][i] == 'Q') return false;
        }
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;
    }

    void backtracking(char[][] chessboard, int n, int row) { // row: 当前遍历至第几行
        if (row == n) {
            ArrayList<String> board = new ArrayList<>();
            // 添加的是当前棋盘的副本，而不是直接引用。这是因为后续的回溯过程会修改棋盘的状态
            // 如果直接添加引用，最终结果列表中存储的将会是最终状态的引用，而不是每一步的状态
            for (int i = 0; i < n; i++) {
                board.add(new String(chessboard[i]));
            }
            result.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            // 判断该位置是否合法
            if (!isValid(row, i, n, chessboard)) continue;
            chessboard[row][i] = 'Q';
            backtracking(chessboard, n, row + 1); // 遍历下一行
            chessboard[row][i] = '.';
        }
    }

    public List<List<String>> method(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtracking(chessboard, n, 0);
        return result;
    }
}