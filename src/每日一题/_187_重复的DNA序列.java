package 每日一题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187_重复的DNA序列 {
//    public List<String> findRepeatedDnaSequences(String s) {
//        Set<String> res = new HashSet<>();
//
//        for (int i = 0; i < s.length() - 10; i++) {
//            String pattern = s.substring(i, i + 10);
//            if (find(pattern, s.substring(i + 1))) {
//                res.add(pattern);
//            }
//        }
//
//        return new ArrayList<>(res);
//    }
//
//    /**
//     * 判断 text中是否出现 pattern
//     */
//    public boolean find(String pattern, String text) {
//        int n = pattern.length();
//
//        int pattern_hash = pattern.hashCode();  // 模式串哈希
//        int sub_hash = text.substring(0, n).hashCode(); // 子串哈希
//
//        // 枚举长度为 10的子串
//        for (int i = 0; i <= text.length() - 10; i++) {
//            // 如果 hashCode相等，再进一步比较两个字符串是否相等
//            if (sub_hash == pattern_hash) {
//                String sub = text.substring(i, i + n);
//                if (pattern.equals(sub)) return true;
//
//            }
//
//            if (i + n < text.length()) { // 防止越界
//                // 更新为下一个子串的哈希值
//                sub_hash = (int) ((sub_hash - text.charAt(i) * Math.pow(31, n - 1)) * 31 + text.charAt(i + n));
//            }
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new _187_重复的DNA序列().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//    }

//    public List<String> findRepeatedDnaSequences(String s) {
//        Set<String> res = new HashSet<>();
//        // 出现过的 DNA序列集合
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i <= s.length() - 10; i++) {
//            String sub = s.substring(i, i + 10);
//            // 如果该 DNA序列已出现过，放入结果集
//            if (set.contains(sub)) {
//                res.add(sub);
//            } else {
//                set.add(sub);
//            }
//        }
//        return new ArrayList<>(res);
//    }


//    /**
//     * 暴力匹配
//     */
//    public List<String> findRepeatedDnaSequences(String s) {
//        Set<String> set = new HashSet<>();
//
//        for (int i = 0; i < s.length() - 10; i++) {
//            String template = s.substring(i, i + 10);
//            if (find(template, s.substring(i + 1))) {
//                set.add(template);
//            }
//        }
//
//        return new ArrayList<>(set);
//    }
//
//    /**
//     * 判断 s中是否出现 template
//     */
//    public boolean find(String template, String s) {
//
//        for (int i = 0; i <= s.length() - 10; i++) {
//            if (s.charAt(i) != template.charAt(0)) continue;
//
//            String sub = s.substring(i, i + 10);
//            if (sub.equals(template)) return true;
//        }
//
//        return false;
//    }
}
