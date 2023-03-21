package 字符串;

/**
 * https://leetcode.cn/problems/prime-palindrome/
 */
public class _866_回文素数 {
    /**
     * 超时了
     * @param n
     * @return
     */
    public int primePalindrome(int n) {
        if (n == 1) return 2;
        for (int i = n; ; i++) {
            if (isSuShu(i) && isMirror(String.valueOf(i))) {
                return i;
            }
        }
    }

    //判断s是否回文
    private boolean isMirror(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;
    }

    //判断v是否是素数
    private boolean isSuShu(int v) {
        for (int i = 2; i < v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

}
