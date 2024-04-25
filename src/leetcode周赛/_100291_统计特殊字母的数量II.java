package leetcode周赛;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/21 11:32
 */
public class _100291_统计特殊字母的数量II {
    public int numberOfSpecialChars(String word) {
        boolean[] flag = new boolean[200];
        Arrays.fill(flag, false);
        char[] cs = word.toCharArray();
        // 用 set防重
        Set<Character> set = new HashSet<>();
        // 黑名单
        Set<Character> blacklist = new HashSet<>();
        for (int i = 0; i < cs.length; i++) {
            flag[cs[i]] = true;
            if (cs[i] >= 'a' && cs[i] <= 'z' && flag[cs[i] - 32]) {
                // 大写在小写前出现过了，那么该字母不能作为答案
                blacklist.add(cs[i]);
            } else if (cs[i] >= 'A' && cs[i] <= 'Z' && flag[cs[i] + 32]) {
                // 小写在大写前出现过了，可能是答案 【后面如果再出现一次小写，就不是答案了】
                set.add(Character.toLowerCase(cs[i]));
            }
        }

        for (Character c : blacklist) {
            set.remove(c);
        }
        return set.size();
    }
}
