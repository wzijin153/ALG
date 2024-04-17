package BackTracking;

/**
 * @program: alghorithm
 * @description: 解数独
 * @author: wangzijin
 * @create: 2024-04-16 20:32
 **/
// https://leetcode.cn/problems/sudoku-solver/description/
public class solveSudoku {
    boolean isValid(int row, int col, char k, char[][] board) {
        // 检查行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) return false;
        }
        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) return false;
        }
        // 检查9宫格范围内
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean backtracking(char[][] board) { // 返回bool说明只要找到一个解就可以返回
        for (int i = 0; i < 9; i++) { // i 代表行
            for (int j = 0; j < 9; j++) { // j 代表列
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(i, j, k, board)) continue;
                    board[i][j] = k;
                    if (backtracking(board)) return true; // 找到一个结果就立即返回
                    board[i][j] = '.';
                }
                return false; // 9个数都试完了，都不行，那么就返回false
            }
        }
        return true; // 遍历完没有返回false，说明找到了合适棋盘位置了
    }

    public void method(char[][] board) {
        backtracking(board);
    }
}