package 二叉树;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class _331_验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].equals("#")) {
                stack.push(strs[i]);
            } else {
                //当待入栈的是“#”则要判断是否栈顶也是“#”
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    try {
                        stack.pop();
                        stack.pop();
                    } catch (EmptyStackException e) {
                        return false;
                    }
                }
                //栈顶没有“#”,可以放入“#”了
                stack.push(strs[i]);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
