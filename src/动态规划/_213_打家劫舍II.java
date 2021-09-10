package 动态规划;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class _213_打家劫舍II {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(
                robRange(nums, 1, nums.length - 1),//最后一家不考虑偷的情况
                robRange(nums, 2, nums.length)  //第一家不偷
        );
    }

    private int robRange(int[] nums, int begin, int end) {
        int[] dp = new int[end + 1]; //取值范围[begin + 1,end]
        dp[begin] = nums[begin - 1];
        for (int i = begin + 1; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1],  //不偷
                    nums[i - 1] + dp[i - 2]);
        }
        return dp[end];
    }
}
