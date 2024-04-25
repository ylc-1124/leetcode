package 动态规划;

public class _746_使用最小花费爬楼梯 {

    /**
     * dp[i] = min{dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]}
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // 到达 i层的，最小花费为 dp[i]
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}
