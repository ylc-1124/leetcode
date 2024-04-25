package 动态规划;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/22 11:55
 */
public class _91_解码方法 {
    /**
     * dp[i] =对s[i]解码 + 对s[i-1,i]解码 =  dp[i-1] + dp[i-2]
     */
    public int numDecodings(String s) {
        int n = s.length();
        // 以 s[i]结尾的字符串，有 dp[i]种解码方法
        int[] dp = new int[n];

        // base case
        dp[0] = canDecoding(s.charAt(0)) ? 1 : 0;

        for (int i = 1; i <= n - 1; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i);

            // 能够对 s[i]解码
            if (canDecoding(c2)) {
                dp[i] += dp[i - 1];
            }

            // 能够对 s[i-1,i]解码
            if (canDecoding(c1, c2)) {
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += 1;
                }
            }

        }

        return dp[n - 1];
    }

    private boolean canDecoding(char c1, char c2) {
        return Integer.valueOf(c1 + "" + c2) >= 10 && Integer.valueOf(c1 + "" + c2) <= 26;
    }

    private boolean canDecoding(char c1) {
        return Integer.parseInt(c1 + "") > 0 && Integer.parseInt(c1 + "") <= 9;
    }
}
