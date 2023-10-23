package 动态规划;

public class _115_不同的子序列 {
    public int numDistinct(String s, String t) {
        // 将原问题转化为：s有多少种方式变成 t，只能选择删除某些字符（前提：s通过删除某些字符一定能够变成t）
        int m = s.length();
        int n = t.length();
        // 使 s前 i个字符，变为 t前 j个字符，有 dp[i][j]种方式
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 这种情况的状态转移不那么容易想到
                    // 要么删除i处的字符，要么删除i之前的字符
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
