package 每日一题;

public class _2586_统计范围内的元音字符串数 {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        int n = words.length;
        for (int i = left; i <= right; i++) {
            String w = words[i];
            if (isYuanYin(w.charAt(0))
                    && isYuanYin(w.charAt(w.length() - 1))) {
                count++;
            }

        }
        return count;
    }

    private boolean isYuanYin(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
