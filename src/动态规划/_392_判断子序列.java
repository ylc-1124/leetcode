package 动态规划;

public class _392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        //双指针
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
