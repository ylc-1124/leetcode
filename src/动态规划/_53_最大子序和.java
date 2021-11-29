package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        //base case
        if (nums.length == 1) return nums[0];
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp += nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
