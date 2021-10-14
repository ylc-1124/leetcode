package 回溯;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class _17_电话号码的字母组合 {
    //结果集
    List<String> res = new LinkedList<>();
    //字母和按键的映射关系
    String[] letterMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder sb) {
        //base case
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        //当前按的是哪个键,注意这里必须把char变成字符串，这样解析
        Integer cur = Integer.parseInt(digits.charAt(index) + "");
        //选择列表，只不过是个字符串，拆分成char[]遍历即可
        String letters = letterMap[cur];
        //遍历选择列表
        for (char selectable : letters.toCharArray()) {
            //做选择
            sb.append(selectable);
            backtrack(digits, index + 1, sb);
            //撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
