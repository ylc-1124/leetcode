package 动态规划;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _70_爬楼梯 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        // 爬上i阶楼梯，有dp[i]种不同爬法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

//    public int climbStairs(int n) {
//        if (n <= 2) return n;
//        //dp[i]定义为爬到第i层楼梯有多少种方式
//        int[] dp = new int[n + 1];
//        //base case
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            //状态转移方程
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
}
