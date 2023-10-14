package 动态规划;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        // 初始化最低价格
        int min_price = prices[0];
        int max_profit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            // 计算在当天售卖的最大利润
            int profit = prices[i] - min_price;
            if (profit > max_profit) {
                max_profit = profit;
            }
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
        }
        return max_profit < 0 ? 0 : max_profit;
    }
}
