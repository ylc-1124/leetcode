package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class _120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();
        // 从起点到 (i, j)最小路径和为 dp[i][j]
        int[][] dp = new int[n][n];
        // base case
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 考虑需要用上哪些子问题，当前状态可以有哪些子状态做出什么选择得到？
                if (j == 0) {
                    // 只能从头上走过来
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 只能左下走过来
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else {
                    // 两个方向都可能走过来，选小的
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);

                }
            }
        }
        // 最后一排状态中最小的就是答案
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        return min;
    }

}
