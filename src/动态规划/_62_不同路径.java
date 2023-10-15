package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class _62_不同路径 {

    public int uniquePaths(int m, int n) {
        // 机器人到 (i, j)有 dp[i][j]种走法
        int[][] dp = new int[m][n];
        // base case
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 终点坐标 (m - 1, n - 1)
        return dp[m - 1][n - 1];
    }

//    public int uniquePaths(int m, int n) {
//        //dp[i][j] 定义为走到第i行第j列有多少种走法 , i取值范围 [1,m] j取值范围[1,n]
//        int[][] dp = new int[m + 1][n + 1];
//        //base case
//        for (int row = 1; row <= m; row++) {
//            dp[row][1] = 1;
//        }
//        for (int col = 1; col <= n; col++) {
//            dp[1][col] = 1;
//        }
//        for (int row = 2; row <= m; row++) {
//            for (int col = 2; col <= n; col++) {
//                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
//            }
//        }
//        return dp[m][n];
//    }
}
