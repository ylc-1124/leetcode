package leetcode周赛;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/26 10:57
 */
public class _373_统计美丽子字符串I {
    public int beautifulSubstrings(String s, int k) {
        int res = 0;
        for (int begin = 0; begin < s.length(); begin++) {
            int vowels = 0, consonants = 0;
            for (int end = begin + 1; end <= s.length(); end++) {
                String sub = s.substring(begin, end);
                int len = sub.length();

                if (sub.charAt(len - 1) == 'a' || sub.charAt(len - 1) == 'e'
                        || sub.charAt(len - 1) == 'i' || sub.charAt(len - 1) == 'o'
                        || sub.charAt(len - 1) == 'u') {

                    vowels++;
                } else {
                    consonants++;
                }

                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    res++;
                }
            }

        }

        return res;
    }
}
