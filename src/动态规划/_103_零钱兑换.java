package 动态规划;

import java.util.Arrays;

public class _103_零钱兑换 {
    /**
     * dp[i] = min(dp[i-coin[0]]+1, dp[i-coin[1]]+1, ....)
     */
    public int coinChange(int[] coins, int amount) {
        // 凑出 i元，最小需要 dp[i]个币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 币最小面额只可能是1，凑出amount最多amount个币也够了
        // base case
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        // 如果还是初始值说明找不开
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
//    public int coinChange(int[] coins, int amount) {
//        // 凑出amount，至少需要dp[amount]个币
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        // base case
//        dp[0] = 0;
//
//        for (int i = 1; i < dp.length; i++) {
//            for (int coin : coins) {
//                // 负金额没法凑出，无解
//                if (i - coin < 0) {
//                    continue;
//                } else {
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
//            }
//        }
//        return dp[amount] == amount + 1 ? -1 : dp[amount];
//
//    }
//    int[] memo;
//
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1];
//        Arrays.fill(memo, -666);
//        return dp(coins, amount);
//    }
//
//    // 凑出amount，至少需要dp(amount)个币
//    private int dp(int[] coins, int amount) {
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//
//        if (memo[amount] != -666) {
//            return memo[amount];
//        }
//
//        // 枚举出需要用到的子问题
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int sub = dp(coins, amount - coin);
//            // 子问题无解，跳过
//            if (sub == -1) continue;
//            res = Math.min(res, sub + 1);
//        }
//        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
//
//        return memo[amount];
//    }
}
