package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class _51_N皇后 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化空棋盘
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(0, board);
        return res;
    }

    /**
     * 在棋盘的第 row行选择皇后的位置
     *
     * @param row 当前做选择的行数
     * @param board 棋盘
     */
    private void backtrack(int row, char[][] board) {
        if (row == board.length) {
            // 找到一个解
            res.add(charArrayToList(board));
            return;
        }
        // 可做选择的列数
        int cols = board[0].length;
        for (int col = 0; col < cols; col++) {
            if (!isValid(board,row,col)) continue;
            // 做选择
            board[row][col] = 'Q';
            backtrack(row + 1, board);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /**
     * 判断棋盘中的该位置是否能够放置皇后
     */
    private boolean isValid(char[][] board, int row, int col) {
        // 检查上方是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查左上方是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 检查右上方是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    /**
     * 将二维棋盘，变为字符串列表
     */
    private List<String> charArrayToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] chars : board) {
            list.add(new String(chars));
        }
        return list;
    }

//    List<List<String>> result = new LinkedList<>();
//
//    public List<List<String>> solveNQueens(int n) {
//        //初始化空棋盘
//        char[][] board = new char[n][n];
//        for (char[] chars : board) {
//            Arrays.fill(chars, '.');
//        }
//        backtrack(0, board);
//        return result;
//    }
//
//    private void backtrack(int row, char[][] board) {
//        if (row == board.length) {
//            result.add(charToList(board));
//            return;
//        }
//        //计算当前行有多少列
//        int cols = board[row].length;
//        //选择列表
//        for (int col = 0; col < cols; col++) {
//            //剪枝 排除不能放皇后的列
//            if (!isValid(board, row, col)) continue;
//            //做选择
//            board[row][col] = 'Q';
//            backtrack(row + 1, board);
//            //撤销选择
//            board[row][col] = '.';
//        }
//    }
//
//    /**
//     * 判断是否可以在这个位置放置皇后
//     */
//    private boolean isValid(char[][] board, int row, int col) {
//        //检查这一列是否有皇后
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][col] == 'Q') return false;
//        }
//
//        //检查左上方是否有皇后
//        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//            if (board[i][j] == 'Q') return false;
//        }
//        //检查右上方是否有皇后
//        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
//            if (board[i][j] == 'Q') return false;
//        }
//        return true;
//    }
//
//    private List<String> charToList(char[][] board) {
//        List<String> list = new LinkedList<>();
//        for (char[] row : board) {
//            list.add(new String(row));
//        }
//        return list;
//    }
}
