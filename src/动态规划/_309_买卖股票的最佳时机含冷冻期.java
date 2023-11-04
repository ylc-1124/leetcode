package 动态规划;

/**
 * 121. 买卖股票的最佳时机
 * 122. 买卖股票的最佳时机 II
 * 123. 买卖股票的最佳时机 III
 * 188. 买卖股票的最佳时机 IV
 * （本题）309. 最佳买卖股票时机含冷冻期
 * 714. 买卖股票的最佳时机含手续费
 * 剑指 Offer 63. 股票的最大利润
 */
public class _309_买卖股票的最佳时机含冷冻期 {

    /**
     * dp[i]=max{prices[i] - prices[i-1] + max{dp[i-3],...dp[0]},
     * prices[i] - prices[i-2] + max{dp[i-4],...dp[0]},
     * ......
     * prices[i] - prices[0]}
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 第 i天卖出股票的最大收益为 dp[i]
        int[] dp = new int[n];
        dp[0] = 0;

        // history_max_profit[i]代表 dp[0..i]的最大收益
        int[] history_max_profit = new int[n];
        history_max_profit[0] = dp[0];

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int profit = prices[i] - prices[j];

                if (j - 2 >= 0) {
                    // 可以累加上历史最大收益
                    profit += history_max_profit[j - 2];
                }
                dp[i] = Math.max(profit, dp[i]);
            }

            // 维护历史最大收益
            history_max_profit[i] = Math.max(history_max_profit[i - 1], dp[i]);
        }

        return history_max_profit[n - 1];
    }
}
