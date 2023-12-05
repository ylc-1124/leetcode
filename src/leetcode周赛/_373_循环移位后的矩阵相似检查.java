package leetcode周赛;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/26 10:30
 */
public class _373_循环移位后的矩阵相似检查 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] mat_copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat_copy[i][j] = mat[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int w = 0; w < k; w++) {
                if ((i + 1) % 2 != 0) {
                    int tmp = mat[i][n - 1];
                    for (int j = n - 2; j >= 0; j--) {
                        mat[i][j + 1] = mat[i][j];
                    }
                    mat[i][0] = tmp;
                } else {
                    int tmp = mat[i][0];
                    for (int j = 1; j <= n - 1; j++) {
                        mat[i][j - 1] = mat[i][j];
                    }
                    mat[i][n - 1] = tmp;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat_copy[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
