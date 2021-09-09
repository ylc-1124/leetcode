package 动态规划;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class _64_最小路径和 {
    public int minPathSum(int[][] grid) {
        /* dp[row][col] 定义为走到第row行 第col列时，最小路径和，
        row取值范围[1,grid.length],col取值范围[grid[0].length] */
        int m= grid.length; //gird的行数
        int n = grid[0].length; //gird的列数
        int[][] dp = new int[m + 1][n + 1];
        //base case
        dp[1][1] = grid[0][0];
        //第一行的路径和是固定的，因为只有一种走法
        for (int col = 2; col <= n; col++) {
            dp[1][col] = dp[1][col - 1] + grid[0][col - 1];
        }
        //第一列的路径和也是固定的
        for (int row = 2; row <= m; row++) {
            dp[row][1] = dp[row - 1][1] + grid[row - 1][0];
        }

        for (int row = 2; row <= m; row++) {
            for (int col = 2; col <= n; col++) {
                //状态转移方程
                dp[row][col] = Math.min(dp[row - 1][col] + grid[row - 1][col - 1],
                        dp[row][col - 1] + grid[row - 1][col - 1]);
            }
        }

        return dp[m][n];
    }
}
