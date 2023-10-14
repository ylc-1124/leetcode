package 动态规划;

public class _746_使用最小花费爬楼梯 {
    // cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; // 楼梯数
        // 爬上第i阶楼梯，最少花费为dp[i]
        int[] dp = new int[n];
        dp[0] = 0; // 可以直接从台阶 1前开始爬
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i <= n - 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        return dp[n - 1];
    }
}
