package 每日一题;

public class _2609_最长平衡子字符串 {
    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        for (int i = 0; i <= s.length() - 2; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                //计算平衡子串长度
                int len = 0;
                for (int left = i, right = i + 1; left >= 0 && right <= s.length() - 1; left--, right++) {
                    if (s.charAt(left) == '0' && s.charAt(right) == '1') {
                        len += 2;
                    } else {
                        break;
                    }
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }
}
