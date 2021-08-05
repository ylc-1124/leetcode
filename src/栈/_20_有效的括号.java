package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //左括号压栈
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {  //右括号弹栈
                if (stack.isEmpty()) return false;
                Character c = stack.pop();
                if (c=='(' && s.charAt(i)!=')') return false;
                if (c=='[' && s.charAt(i)!=']') return false;
                if (c=='{' && s.charAt(i)!='}') return false;
            }
        }

        return stack.isEmpty();
    }
}
