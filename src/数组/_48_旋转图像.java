package 数组;

/**
 * https://leetcode.cn/problems/rotate-image/
 */
public class _48_旋转图像 {
    public void rotate(int[][] matrix) {
        //n x n 的矩阵
        int n = matrix.length;
        //保存 matrix的副本
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[i][j] = matrix[i][j];
            }
        }
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = matrix_new[n - col - 1][row];
            }
        }
    }
}
