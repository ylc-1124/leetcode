package 动态规划;

public class _516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // 在子串s[i..j]中，最长回文子序列的长度为 dp[i][j]
        int[][] dp = new int[len][len];
        // base case 字符构成的最长回文子序列为 1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            // 只需计算 i < j的状态
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 放入一个字符不会更改最长回文子序列的长度
                    // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
