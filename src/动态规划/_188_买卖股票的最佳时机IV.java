package 动态规划;

public class _188_买卖股票的最佳时机IV {
    /**
     * dp[i][j][0]=max{dp[i-1][j][0], dp[i-1][j][1]+prices[i]}
     * dp[i][j][1]=max{dp[i-1][j][1], dp[i-1][j-1][0]-prices[i]}
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 至多进行 j次交易的前提下，在第 i天交易结束后，手里无股票，最大利润为 dp[i][j][0]
        // 至多进行 j次交易的前提下，在第 i天交易结束后，手里有股票，最大利润为 dp[i][j][1]
        int[][][] dp = new int[n][k + 1][2];
        // base case
        // 允许交易的情况下，第 0天交易结束后，如果持有股票，则最大利润是负的
        // 至多交易 0次的状态，利润为 0
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        // 返回答案
        return dp[n - 1][k][0];
    }
}
