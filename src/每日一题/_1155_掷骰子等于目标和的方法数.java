package 每日一题;

public class _1155_掷骰子等于目标和的方法数 {

    private static final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        // i个筛子，凑出 j ，有 dp[i][j]种方式
        int[][] dp = new int[n + 1][target + 1];

        // base case
        // 一个筛子摇出 1-k面的方式只有一种
        for (int i = 1; i <= target; i++) {
            if (i <= k) dp[1][i] = 1;
        }
        // n个筛子摇出n的方式只有一种
        for (int i = 1; i <= n; i++) {
            if (i <= target) dp[i][i] = 1;
        }

        // dp[i][j] = dp[i-1][j-1]+dp[i-1][j-2]+...dp[i-1][j-k]
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= target; j++) {
                for (int num = j - 1; num >= j - k && num >= 0; num--) {
                    dp[i][j] = ((dp[i][j] + dp[i - 1][num]) % MOD);
                }
            }
        }

        return dp[n][target];
    }
}
