package 动态规划;

public class _123_买卖股票的最佳时机III {
    /**
     * dp[i][j][0]=max{dp[i-1][j][0], dp[i-1][j][1]+prices[i]}
     * dp[i][j][1]=max{dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]}
     * 用昨天至多交易 j-1次的结果，今天买入股票一次，才能把状态转为：至多允许交易 j次的结果
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        /*限制交易次数的股票题，有三个状态，允许交易的次数作为第二个状态*/

        // 允许进行 j次交易的情况下，第 i天交易结束后，没有股票时, 最大利润为 dp[i][j][0]
        // 允许进行 j次交易的情况下，第 i天交易结束后，拥有股票时, 最大利润为 dp[i][j][1]
        int[][][] dp = new int[n][2 + 1][2];

        // base case
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        // 答案
        return dp[n - 1][2][0];
    }
}
