package 每日一题;

import java.util.Arrays;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/30 20:32
 */
public class _1657_确定两个字符串是否接近 {
    /**
     * 两个字符串接近的充分必要条件为：
     * （1）两个字符串出现的字符集相等
     * （2）字符出现次数数组排序后相等
     */
    public boolean closeStrings(String word1, String word2) {
        // 存放每个字母的出现次数：count1[0]存放'a'出现的次数...
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            // 字符集不同
            if (count1[i] == 0 && count2[i] > 0 || count1[i] > 0 && count2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);

        // 字符出现次数排序后相等
        return Arrays.equals(count1, count2);
    }
}
