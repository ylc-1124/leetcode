package 动态规划;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class _198_打家劫舍 {

    public int rob(int[] nums) {
        //dp[i]定义为路过第 i 个住户偷到最大的金额,i有效范围[1,nums.length]
        int[] dp = new int[nums.length + 1];
        dp[1]=nums[0];
        for (int i = 2; i <= nums.length; i++) {
            //偷或不偷中，选择最大的
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length];
    }
}
