package leetcode周赛;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/19 10:37
 */
public class _372_使三个字符串相等 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int len = Math.min(s1.length(), s2.length());
        len = Math.min(len, s3.length());

        int idx = 0;
        while (idx < len && s1.charAt(idx) == s2.charAt(idx) && s2.charAt(idx) == s3.charAt(idx)) {
            idx++;
        }
        if (idx == 0) {
            // 最左边不相等
            return -1;
        } else {
            int res1 = s1.length() - idx;
            int res2 = s2.length() - idx;
            int res3 = s3.length() - idx;
            return res1 + res2 + res3;
        }
    }
}
