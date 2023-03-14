package 数组;

/**
 * https://leetcode.cn/problems/count-primes/
 */
public class _204_计数质数 {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isZS(i)) count++;
        }
        return count;
    }

    //判断n是否是质数
    private boolean isZS(int n) {
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
