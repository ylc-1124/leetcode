package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换 {


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        //dp[i]表示凑成金额 i所需最少硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //硬币的面值大于要找零的金额
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0) return 0;
//        /* dp[i]定义为零钱数量为i兑换成硬币的最小个数*/
//        int[] dp = new int[amount + 1];
//        //这里默认全设置成最大值-1是为了防止溢出，留出+1能变成最大值，从而不会被min选中的空间
//        Arrays.fill(dp, Integer.MAX_VALUE - 1);
//
//        //base case
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            //每次选择一种面值，求出选择哪种面值硬币个数最少
//            for (int coin : coins) {
//                //剪枝,无解
//                if (i < coin) continue;
//                //状态转移方程,求出最优子结构
//                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//            }
//
//        }
//        return (dp[amount] == Integer.MAX_VALUE - 1) ? -1 : dp[amount];
//    }

}
