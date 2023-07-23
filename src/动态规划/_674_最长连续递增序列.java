package 动态规划;

import java.util.Arrays;

public class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        //dp[i]表示以nums[i]为末尾的最长连续递增子序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
