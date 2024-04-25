package 动态规划;

import java.util.Arrays;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/20 12:30
 */
public class _377_组合总和Ⅳ {
    /**
     * 问题转换：有 target个阶梯，每次可以选择爬 nums[i]层，总共有多少种爬到终点的方式？
     *
     * 状态转移方程：dp[i] = dp[i-nums[0]] + dp[i-nums[1]] + ... + dp[i-nums[end]]
     */
    public int combinationSum4(int[] nums, int target) {
        // 爬上 i 层楼梯，有 dp[i]种方式
        int[] dp = new int[target + 1];
        // base case
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {             // 台阶数
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
