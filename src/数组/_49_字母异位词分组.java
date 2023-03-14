package 数组;

import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/
 */
public class _49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        //1、字母异位词按各位字符排完序后应该是一样的 => 作为key
        //这些字母异位词可以映射到同一个value，即可以找到同一个list，然后存入
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //将当前字符串各位进行排序
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
