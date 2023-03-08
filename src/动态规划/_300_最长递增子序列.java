package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class _300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]是以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        //base case
        Arrays.fill(dp, 1);
        //穷举状态
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
//    public int lengthOfLIS(int[] nums) { //动态规划
//        if (nums == null || nums.length == 0) return 0;
//
//        //dp[i]表示：序列的前i个元素中最长递增子序列 （以nums[i-1]为结尾的最长递增子序列长度）
//        // i 属于 [1,nums.length]
//        int[] dp = new int[nums.length + 1];
//        int max = dp[0] = 1;
//        for (int i = 1; i <= nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 1; j <= i; j++) {
//                if (nums[i - 1] <= nums[j - 1]) continue;
//                dp[i] = Math.max(dp[i], dp[j] + 1);
//            }
//            max = Math.max(dp[i], max);
//        }
//        return max;
//    }
}
