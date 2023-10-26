package 动态规划;

public class _494_目标和 {
    /**
     * 想不到的解法
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if(sum < Math.abs(target)){
            return 0;
        }

        if ((target + sum) % 2 != 0) return 0;

        // 加法子集之和
        int x = (target + sum) / 2;

        // 对于前 i个物品，装满容量为 j的背包，有 dp[i][j]种方式
        int[][] dp = new int[n + 1][x + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        int numZero = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == 0) {
                numZero++;
            }
            dp[i][0] = (int) Math.pow(2, numZero);
        }

        for (int i = 1; i <= n; i++) { // 物品数
            for (int j = 1; j <= x; j++) { // 容量
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][x];
    }
}
