package 动态规划;


import java.util.*;

public class _139_单词拆分 {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        // base case
        if ("".equals(s)) return true;
        if (memo.containsKey(s)) return memo.get(s);

        for (String word : wordDict) {
            int len = word.length();
            if (len > s.length()) continue;
            String sb = s.substring(0, len);
            if (word.equals(sb)) {
                boolean result = wordBreak(s.substring(len), wordDict);
                memo.put(s.substring(len), result);
                if (result) return true;
            }
        }
        return false;
    }
}
