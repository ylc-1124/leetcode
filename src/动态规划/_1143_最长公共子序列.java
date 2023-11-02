package 动态规划;

public class _1143_最长公共子序列 {

    public int longestCommonSubsequence(String text1,
                                        String text2) {
        int m = text1.length();
        int n = text2.length();
        // text1前 i个字符与 text2前 j个字符的公共子序列的最大长度为 dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果 text1的第 i个字符与 text2第 j个字符相等，那么状态转移就是在前面的答案上+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果两字符不同，比一比谁放进去比较大
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }


        return dp[m][n];
    }

}
