package leetcode周赛;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/21 11:15
 */
public class _100294_统计特殊字母的数量I {

    public int numberOfSpecialChars(String word) {
        boolean[] flag = new boolean[200];
        Arrays.fill(flag, false);
        char[] cs = word.toCharArray();
        // 用 set防重
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < cs.length; i++) {
            flag[cs[i]] = true;
            if (cs[i] >= 'a' && cs[i] <= 'z' && flag[cs[i] - 32]) {
                set.add(cs[i]);
            } else if (cs[i] >= 'A' && cs[i] <= 'Z' && flag[cs[i] + 32]) {
                set.add(Character.toLowerCase(cs[i]));
            }
        }

        return set.size();
    }
}
