package 动态规划;

public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) return 0;
        //dp[i][j] 表示 以chars1[i - 1]和chars2[i - 1]结尾的最长公共子序列的值
        // dp[i][j] = max{ 结尾值相同时 dp[i-1][j-1] + 1 , 结尾值不同时 max{dp[i-1][j],dp[i][j-1]}}
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        return dp[chars1.length][chars2.length];
    }
}
