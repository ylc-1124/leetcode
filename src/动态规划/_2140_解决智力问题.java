package 动态规划;

/**
 * @description: 类似打家劫舍，比打家劫舍难
 * @author: ylc
 * @date: 2024/4/20 13:10
 */
public class _2140_解决智力问题 {
    /**
     * dp[i] = max{解决，跳过} = max{point[i]+dp[i+brainpower[i]+1], dp[i+1]}
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // 对于 q[i...n-1]道题，能获得的最大分数为 dp[i]
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            int j = i + questions[i][1] + 1;   // 后面可做的第一道题的下标

            dp[i] = Math.max(questions[i][0] + (j < n ? dp[j] : 0),  // 解决
                    dp[i + 1]); // 跳过
        }
        return dp[0];
    }

}
