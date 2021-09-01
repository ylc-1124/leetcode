package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class _51_N皇后 {
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        //初始化空棋盘
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(0, board);
        return result;
    }

    private void backtrack(int row, char[][] board) {
        if (row == board.length) {
            result.add(charToList(board));
            return;
        }
        //计算当前行有多少列
        int cols = board[row].length;
        //选择列表
        for (int col = 0; col < cols; col++) {
            //剪枝 排除不能放皇后的列
            if (!isValid(board, row, col)) continue;
            //做选择
            board[row][col] = 'Q';
            backtrack(row + 1, board);
            //撤销选择
            board[row][col] = '.';
        }
    }

    /**
     * 判断是否可以在这个位置放置皇后
     */
    private boolean isValid(char[][] board, int row, int col) {
        //检查这一列是否有皇后
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }

        //检查左上方是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //检查右上方是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> charToList(char[][] board) {
        List<String> list = new LinkedList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
