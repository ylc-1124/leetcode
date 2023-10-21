package 动态规划;

public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 回文串长度为奇数的情况
            String s1 = longestPalindrome(s, i, i);
            // 回文串长度为偶数的情况
            String s2 = longestPalindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 寻找以s[i],s[j]为中心的最长回文子串
     * 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。
     * 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。
     */
    public String longestPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()
                && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

}
