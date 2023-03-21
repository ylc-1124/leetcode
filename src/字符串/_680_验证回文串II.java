package 字符串;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-palindrome-ii/description/
 */
public class _680_验证回文串II {
    /**
     * 思路可以但是超时了
     *
     * @param s
     * @return
     */
//    public boolean validPalindrome(String s) {
//        //本身就回文
//        if (isMirror(s)) return true;
//        //本身不回文，尝试删除一个元素看能否回文
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            //删除charArray[i]判断是否回文
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < charArray.length; j++) {
//                if (j != i) {
//                    sb.append(charArray[j]);
//                }
//            }
//            if (isMirror(String.valueOf(sb))) return true;
//        }
//        return false;
//    }

    //双指针判断回文字符串
    public boolean validPalindrome(String s) {
        if (isMirror(s, 0, s.length() - 1)) return true;
        //找到第一对不相等的low和high
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                //删除low处元素判断是否回文
                if (isMirror(s, low + 1, high)) return true;
                //删除high处元素判断是否回文
                if (isMirror(s, low, high - 1)) return true;
                //不可能回文了
                return false;
            } else {
                low++;
                high--;
            }
        }
        return false;
    }

    private boolean isMirror(String s, int low, int high) {
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
