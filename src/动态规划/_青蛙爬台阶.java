package 动态规划;

import java.util.Scanner;

/**
 * 一次 1 - n
 */
public class _青蛙爬台阶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println(1);
            return;
        }
        //dp[i]表示爬到第i层楼梯有多少爬法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        System.out.println(dp[n]);
    }
}
