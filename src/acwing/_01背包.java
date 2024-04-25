package acwing;

import java.util.Scanner;

/**
 * @description: 0-1背包问题
 * @author: ylc
 * @date: 2023/12/13 10:23
 */
public class _01背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 物品数
        int v = sc.nextInt(); // 背包容量
        int[] value = new int[n]; // 物品的价值
        int[] weight = new int[n]; // 物品的重量
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        // 对于前 i个物品，背包容量为 j时，可以装入的最大价值为 dp[i][j]
        int[][] dp = new int[n + 1][v + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                // 判断物品i能否装入背包
                if (j - weight[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], // 不装入
                            dp[i - 1][j - weight[i - 1]] + value[i - 1]); // 装入
                }
            }
        }

        // 输出结果
        System.out.println(dp[n][v]);
    }
}
