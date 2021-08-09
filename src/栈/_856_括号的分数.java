package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //因为遇到右括号每次得弹出两次值
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                //遇到右括号
                int score1 = stack.pop();
                int score2 = stack.pop();
                stack.push(Math.max(2 * score1, 1) + score2);
            }
        }
        return stack.pop();
    }
}
