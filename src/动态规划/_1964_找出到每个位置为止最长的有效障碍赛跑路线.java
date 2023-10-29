package 动态规划;

public class _1964_找出到每个位置为止最长的有效障碍赛跑路线 {
    /**
     * 最长递增子序列的变体
     */
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        // 以 obstacles[i]为结尾的递增子序列 最大长度为 dp[i]
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            boolean hasSub = false;
            for (int j = 0; j < i; j++) {
                if (obstacles[j] <= obstacles[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    hasSub = true;
                }
            }
            if (!hasSub) {
                dp[i] = 1;
            }
        }

        return dp;
    }
}
