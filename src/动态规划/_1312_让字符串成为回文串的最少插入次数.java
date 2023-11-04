package 动态规划;

public class _1312_让字符串成为回文串的最少插入次数 {
    /**
     * i和 j字符相同：dp[i][j] = min{dp[i][j-1]+1, dp[i+1][j]+1,dp[i+1][j-1]}
     * i和 j字符不同：dp[i][j] = min{dp[i][j-1]+1, dp[i+1][j]+1}
     */
    public int minInsertions(String s) {
        int n = s.length();
        // 使 s[i..j]变成回文串, 操作次数最少为 dp[i][j]
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                if (i >= j) continue;
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
