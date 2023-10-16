package 动态规划;

public class _931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // 到 (i, j)的最小路径和为 dp[i][j]
        int[][] dp = new int[n][n];
        // base case
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    min = Math.min(min, dp[i - 1][j + 1]);
                    dp[i][j] = min + matrix[i][j];
                }
            }
        }

        // 找返回的结果
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
