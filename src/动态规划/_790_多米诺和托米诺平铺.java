package 动态规划;

public class _790_多米诺和托米诺平铺 {
    public int numTilings(int n) {
        if (n <= 2) return n;
        // 平铺长为 i的面板，有 dp[i]种方式
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;  //不用动算是1种方式
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        long sum = dp[1] + dp[0];  // 用 long避免越界
        int m = (int) (Math.pow(10, 9) + 7);
        for (int i = 4; i <= n; i++) {
            // dp[i] = dp[i-1]+dp[i-2] + (dp[i-3] + ... + dp[0]) * 2
            dp[i] = (int) ((dp[i - 1] + dp[i - 2] + sum * 2) % m);

            sum += dp[i - 2]; // 维护下个状态要用到的 (dp[i-3] + ... + dp[0])
        }

        return dp[n];
    }
}
