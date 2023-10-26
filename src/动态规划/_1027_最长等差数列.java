package 动态规划;

import java.util.Arrays;

public class _1027_最长等差数列 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        // 以 nums[i]为结尾，公差为 diff的等差数列的 最大长度为 dp[i][diff + 500]
        int[][] dp = new int[n][1001];

        // 初始值
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j]; // 公差
                dp[i][diff + 500] = Math.max(dp[j][diff + 500] + 1, dp[i][diff + 500]);
            }
        }


        // 找答案
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1000; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
