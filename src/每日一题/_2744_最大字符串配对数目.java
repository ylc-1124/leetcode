package 每日一题;

/**
 * @description:
 * @author: ylc
 * @date: 2024/1/17 11:52
 */
public class _2744_最大字符串配对数目 {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isMirror(words[i], words[j])) count++;
            }
        }

        return count;
    }

    private boolean isMirror(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int p1 = 0, p2 = s1.length() - 1;
        while (p1 < s1.length() && p2 >= 0) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }
}
