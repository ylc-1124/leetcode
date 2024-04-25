package 动态规划;

/**
 * @description: 环形房屋偷盗，当房屋 > 2时，需要考虑首尾问题，至多偷一个 => 限定偷盗范围
 * @author: ylc
 * @date: 2023/12/6 16:29
 */
public class _LCR090_打家劫舍II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }
    }

    /**
     * 指定偷盗范围
     */
    public int rob(int[] nums, int begin, int end) {
        // 有多少家可以偷
        int range = end - begin + 1;
        // 偷盗到第 i 家，最多能偷盗 dp[i]
        int[] dp = new int[range];
        dp[0] = nums[begin];
        dp[1] = Math.max(nums[begin], nums[begin + 1]);
        for (int i = 2; i < range; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[begin + i]);
        }
        return dp[range - 1];
    }
}
