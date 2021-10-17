package 回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class _22_括号生成 {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder track = new StringBuilder();
        dfs(track, n,n);
        return res;
    }

    private void dfs(StringBuilder track, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        //优先加左括号
        if (left > 0) {
            track.append('(');
            dfs(track, left - 1, right);
            track.deleteCharAt(track.length() - 1);
        }
        //左括号不能加了，开始加右括号
        if (right > left) {
            track.append(')');
            dfs(track, left, right - 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
