package 动态规划;

public class _714_买卖股票的最佳时机含手续费 {
    /**
     * dp[i][0]=max{dp[i-1][0], dp[i-1][1]+prices[i]-fee}
     * dp[i][1]=max{dp[i-1][1], dp[i-1][0]-prices[i]}
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 第 i天交易完成后，手里没股票时的最大利润为 dp[i][0]
        // 第 i天交易完成后，手里有股票时的最大利润为 dp[i][1]
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 找答案
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(dp[i][0], maxProfit);
            maxProfit = Math.max(dp[i][1], maxProfit);
        }
        return maxProfit;
    }
//    /**
//     * dp[i] = max{prices[i]-prices[i-1]-2 + max{dp[i-2],...,dp[0]},
//     *             prices[i]-prices[i-2]-2 + max{dp[i-3],...,dp[0]},
//     *             ......
//     *             prices[i]-prices[0]}
//     */
//    public int maxProfit(int[] prices, int fee) {
//        int n = prices.length;
//        // 在第 i天卖出股票，能获得的累计最大收益为 dp[i]
//        int[] dp = new int[n];
//        dp[0] = 0;
//        // history_max_profit[i]代表到第 i天为止，能获得的最大累计收益
//        int[] history_max_profit = new int[n];
//
//        for (int i = 1; i < n; i++) {
//            // 尝试在前面的每一天卖出股票（这里导致耗时严重）
//            for (int j = i - 1; j >= 0; j--) {
//                int profit = prices[i] - prices[j] - fee;
//                if (j - 1 >= 0) {
//                    profit += history_max_profit[j - 1];
//                }
//                dp[i] = Math.max(dp[i], profit);
//            }
//            history_max_profit[i] = Math.max(history_max_profit[i - 1], dp[i]);
//        }
//
//        return history_max_profit[n - 1];
//    }
}
