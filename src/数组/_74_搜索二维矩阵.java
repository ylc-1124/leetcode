package 数组;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/
 */
public class _74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //查找可能在哪一行
        int row = -1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                row = i;
                break;
            }
        }
        //target大于矩阵中所有值，必然不在其中
        if (row == -1) return false;

        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == target) return true;
        }
        return false;
    }
}
