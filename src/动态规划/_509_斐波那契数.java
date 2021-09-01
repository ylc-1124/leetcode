package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class _509_斐波那契数 {

    public int fib(int n) {
        if (n < 2) return n;
        //记忆化搜索
        int[] memo = new int[n + 1];
        Arrays.fill(memo,-666);
        memo[0] = 0;
        memo[1] = 1;
       return fib(n, memo);
    }

    private int fib(int n, int[] memo) {
        if (memo[n] != -666) return memo[n];
        return memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    }

}
