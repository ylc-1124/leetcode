package 动态规划;

public class _72_编辑距离 {
    /**
     * 从word1转变为word2所需要的最小编辑次数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // word1前i个字符串变为word2前j个字符串的最小编辑次数
        int[][] dp = new int[m + 1][n + 1];

        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
