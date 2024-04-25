package luogu;

import java.util.Scanner;

/**
 * @description: 最长公共子序列 (MLE)
 * @author: ylc
 * @date: 2023/12/13 9:55
 */
public class _P1439_模板_最长公共子序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 两个字符串的长度为 n
        int n = sc.nextInt();
        int[] text1 = new int[n];
        int[] text2 = new int[n];
        for (int i = 0; i < n; i++) {
            text1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            text2[i] = sc.nextInt();
        }

        // text1前 i个字符与 text2前 j个字符的最长公共子序列长度为 dp[i][j]
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 判断两个子串最后一个字符是否相等
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // 输出结果
        System.out.println(dp[n][n]);
    }
}
