package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class _318_最大单词长度乘积 {

    public int maxProduct(String[] words) {

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                set.add(word.charAt(j));
            }

            for (int j = i + 1; j < words.length; j++) {
                String w = words[j];
                boolean flag = false; // 是否包含公共字母

                for (int k = 0; k < w.length(); k++) {
                    if (set.contains(w.charAt(k))) {
                        flag = true;
                        break;
                    }
                }

                // 不包含公共字母则计算结果
                if (!flag) {
                    max = Math.max(max, word.length() * w.length());
                }
            }
        }

        return max;
    }
}
