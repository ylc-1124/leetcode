package 数组;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class _121_买卖股票的最佳时机 {
    //    public int maxProfit(int[] prices) { //超过时间限制
//        int maxProfit = 0;
//        //在价格为prices[i]时买入股票,如果卖出那天价格最高即获得了最大利润
//        for (int i = 0; i < prices.length; i++) {
//            //找出后面几天的最高价
//            int maxPrice = Integer.MIN_VALUE;
//            int profit = 0;
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] > maxPrice) {
//                    maxPrice = prices[j];
//                }
//            }
//            //本次利润（卖出价格大于买入价格才有利润）
//            if (maxPrice > prices[i]) {
//                profit = maxPrice - prices[i];
//            }
//            //更新最大利润
//            if (profit > maxProfit) {
//                maxProfit = profit;
//            }
//        }
//        return maxProfit;
//    }
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE; //记录历史最低价
        //在prices[i]卖出，则应该在[0,i-1]最低点买入时，得出最大利润
        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            //维护历史最低价
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new _121_买卖股票的最佳时机().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
