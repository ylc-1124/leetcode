package 回溯;

import java.util.Arrays;

/**
 * @description:
 * @author: ylc
 * @date: 2024/1/17 12:07
 */
public class _37_解数独 {

    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
    }

    // 返回 bool类型，表示是否找到一个可行解
    private boolean backtrack(int row, int col, char[][] board) {
        // 如果选择到第9行，说明已经找到可行解了
        if (row == 9) return true;
        // 如果列超棋盘范围，枚举下一行
        if (col == 9) {
            return backtrack(row + 1, 0, board);
        }
        // 如果当前位置有数字，则不需要枚举
        if (board[row][col] != '.') {
            return backtrack(row, col + 1, board);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 剪枝
            if (!isValid(row, col, board, ch)) continue;
            // 做选择
            board[row][col] = ch;
            if (backtrack(row, col + 1, board)) {
                return true;
            }
            // 撤销选择
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(int row, int col, char[][] board, char ch) {
        // 如果同行已有
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }
        }
        // 如果同列有
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }
        // 如果所在3x3区域有
        int x = row / 3;
        int y = col / 3;
        // 3x3小区域的左上坐标
        x *= 3;
        y *= 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

//    char[][] res;
//
//    public void solveSudoku(char[][] board) {
//        res = board;
//        char[][] newBoard = new char[9][9];
//        // 复制初始棋盘
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                newBoard[i][j] = board[i][j];
//            }
//        }
//        backtrack(0, 0, newBoard);
//    }
//
//    /**
//     * 从 (0, 0)开始做选择
//     */
//    private void backtrack(int row, int col, char[][] board) {
//        // base case 穷举到第 9行说明找到了一个可行解
//        if (row == 9) {
//            // 最终结果
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    res[i][j] = board[i][j];
//                }
//            }
//            return;
//        }
//
//        // 穷举到最后一列就换行
//        if (col == 9) {
//            backtrack(row + 1, 0, board);
//            return;
//        }
//
//        // 如果该位置有数字，不用我们做选择
//        if (board[row][col] != '.') {
//            backtrack(row, col + 1, board);
//            return;
//        }
//
//
//        for (char ch = '1'; ch <= '9'; ch++) {
//            // 剪枝
//            if (!isValid(row, col, board, ch)) continue;
//            // 做选择
//            board[row][col] = ch;
//            backtrack(row, col + 1, board);
//            // 撤销选择
//            board[row][col] = '.';
//        }
//    }
//
//    private boolean isValid(int row, int col, char[][] board, char ch) {
//
//
//        // 如果同行已有
//        for (int i = 0; i < 9; i++) {
//            if (board[row][i] == ch) {
//                return false;
//            }
//        }
//
//        // 如果同列有
//        for (int i = 0; i < 9; i++) {
//            if (board[i][col] == ch) {
//                return false;
//            }
//        }
//
//        // 如果所在3x3区域有
//        int x = row / 3;
//        int y = col / 3;
//        // 3x3小区域的左上坐标
//        x *= 3;
//        y *= 3;
//        for (int i = x; i < x + 3; i++) {
//            for (int j = y; j < y + 3; j++) {
//                if (board[i][j] == ch) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


}
