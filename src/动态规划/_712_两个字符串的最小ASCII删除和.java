package 动态规划;

public class _712_两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 使s1[0..i]与s2[0..j]相等，所需删除字符的ASCII值的最小和为 dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += s1.charAt(j);
            }
            dp[i][0] = sum;
        }
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += s2.charAt(j);
            }
            dp[0][i] = sum;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j - 1),
                            dp[i - 1][j] + s1.charAt(i - 1));
                }
            }
        }

        return dp[m][n];
    }

}
