package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class _213_打家劫舍II {

    int[] memo;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        memo = new int[nums.length];
        Arrays.fill(memo, -666);
        /*由题意：第一家住户和最后一家住户最多只能偷其中一家
         * 考虑两种情况：1、第一家包含在可选择是否偷盗的范围中
         *            2、第一家排除在外，最后一家包含在可选择是否偷盗的范围中
         * ps：这两种情况中其实已经覆盖了这两家都不偷盗的情况了*/
        int notInvolveLast = dp(nums, nums.length - 2, 0);
        Arrays.fill(memo, -666); //因为两次递归共用的一个备忘录，所以要清空一下

        int notInvolveFirst = dp(nums, nums.length - 1, 1);
        return Math.max(notInvolveLast, notInvolveFirst);
    }

    private int dp(int[] nums, int cur, int begin) {
        if (cur < begin) return 0;
        //0、查备忘录
        if (memo[cur] != -666) return memo[cur];
        //1、选择偷当前住户(前提没有偷他前一家)
        int doIt = nums[cur] + dp(nums, cur - 2, begin);
        //2、选择不偷当前住户
        int notDoIt = dp(nums, cur - 1, begin);
        memo[cur] = Math.max(doIt, notDoIt);
        return memo[cur];
    }


   /* public int rob(int[] nums) {
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
    }*/
}
