package 动态规划;

public class _673_最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 以 nums[i]为结尾的最长递增子序列的 长度为 dp[i][0], 个数为 dp[i][1]
        int[][] dp = new int[n][2];

        // base case
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            // 求出以 nums[i]结尾的最长递增子序列的长度
            boolean hasSub = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                    hasSub = true;
                }
            }

            if (!hasSub) {
                // nums[i]左侧没有比他小的元素，那么他的解如下
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else {
                // 求以 nums[i]结尾的最长递增子序列的个数
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[j][0] + 1 == dp[i][0]) {
                            dp[i][1] += dp[j][1];
                        }
                    }
                }
            }
        }

        // 找答案
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == maxLen) {
                res += dp[i][1];
            }
        }
        return res;
    }
}
