package 动态规划;

/**
 * 转换成背包问题：有一个背包，最大容量为 amount，有一系列物品 coins，
 * 每个物品的重量为 coins[i]，每个物品的数量无限。
 * 请问有多少种方法，能够把背包恰好装满？
 */
public class _518_零钱兑换II {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp[i][j]定义为：若只使用前i种面值的币，当金额为j时，有dp[i][j]种凑法
        int[][] dp = new int[coins.length + 1][amount + 1];
        // base case
        // 没币用，没法凑
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        // 凑0元，一动不动是唯一的凑法
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 穷举状态
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 状态转移
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // 想要返回的答案
        return dp[coins.length][amount];
    }

}
