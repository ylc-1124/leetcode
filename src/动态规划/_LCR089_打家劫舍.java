package 动态规划;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/6 16:14
 */
public class _LCR089_打家劫舍 {
    /**
     * dp[i] = max{不偷,偷}=max{dp[i-1], dp[i-2] + nums[i]}
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // 偷到第 i个房子，最多能偷到 dp[i]元
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }


        return dp[n - 1];
    }
}
