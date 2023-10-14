package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class _300_最长递增子序列 {

    /**
     * 状态：数字，即 nums[i]
     * 选择：索引（导致数字变换）
     * 数组定义：dp[i]是以nums[i]作为结尾的 最长递增子序列的长度
     * base case：dp[0] = 1
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始值
        Arrays.fill(dp, 1);
        // base case
        dp[0] = 1;
        // 递推求解
        for (int i = 1; i < nums.length; i++) {
            // 使用已知的子问题解求当前状态的解（遍历选择来获取子问题解）
            // 枚举出nums[i]前面的所有值小于nums[i]的问题解（只有这些状态对求解当前问题有用）
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        // 找出dp数组中的最大值，即答案
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }


//    public int lengthOfLIS(int[] nums) {
//        //dp[i]是以nums[i]结尾的最长递增子序列的长度
//        int[] dp = new int[nums.length];
//        //base case
//        Arrays.fill(dp, 1);
//        //穷举状态
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < dp.length; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

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
