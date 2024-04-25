package luogu;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2024/1/15 23:31
 */
public class _P1562_还是N皇后 {
    static int res = 0;  // 记录n皇后的放置方案数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 棋盘 nxn维
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            // '*'代表可放  '.'代表不可放
            board[i] = sc.next().toCharArray();
        }
        backtrack(0, board);
        // 打印最终方案数
        System.out.println(res);
    }

    /**
     * 在棋盘第 row行选择皇后的位置
     */
    private static void backtrack(int row, char[][] board) {
        if (row == board.length) {
            res++;
            return;
        }
        // 可选择的位置
        int cols = board[0].length;
        for (int col = 0; col < cols; col++) {
            if (!isValid(board,row,col)) continue;
            // 做选择
            board[row][col] = 'Q';
            backtrack(row + 1, board);
            // 撤销选择
            board[row][col] = '*';
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        // 检查棋盘位置是否本身不可放
        if (board[row][col] == '.') return false;
        // 检查上方是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查左上方有无皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // 检查右上方有无皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
