package 字符串;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-palindrome/
 */
public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        //遍历字符数组 1、遇到小写字母直接拼接  2、遇到大写字母转成小写后拼接
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(String.valueOf(c).toLowerCase());
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        //判断回文
        return isMirror(String.valueOf(sb));
    }

    private boolean isMirror(String s) {
        //栈判断回文
//        Stack<Character> stack = new Stack<>();
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            stack.push(charArray[i]);
//        }
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] != stack.pop()) return false;
//        }

        //双指针判断回文
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;
    }

}
