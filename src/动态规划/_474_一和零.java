package 动态规划;

public class _474_一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 转换成 0-1背包问题
        // 对于前 i个物品，当背包能放 0和 1的个数分别为 j和 k时，最多能放多少物品
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 是否放入物品 strs[i]
                    int num_1 = count_1(strs[i - 1]);
                    int num_0 = strs[i - 1].length() - num_1;
                    if (j - num_0 >= 0 && k - num_1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - num_0][k - num_1] + 1,
                                dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    public int count_1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
}
