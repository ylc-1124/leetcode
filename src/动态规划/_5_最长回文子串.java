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
