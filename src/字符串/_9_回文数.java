package 字符串;

/**
 * https://leetcode.cn/problems/palindrome-number/
 */
public class _9_回文数 {
    //转成字符串判断是否回文，负数一定不回文
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return isMirror(String.valueOf(x));
    }

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
}
