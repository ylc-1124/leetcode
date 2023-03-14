package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/length-of-last-word/
 */
public class _58_最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        while (index >= 0 && chars[index] == ' ') index--;
        int end = index; //最后一个单词的最后一个字母的下标
        while (index >= 0 && chars[index] != ' ') index--;
        int start = index + 1;//最后一个单词的首字母下标
        return end - start + 1;
    }

    //ac
//    public int lengthOfLastWord(String s) {
//        char[] charArray = s.toCharArray();
//        List<String> list = new ArrayList<>();
//        int index = 0;
//        while (index < charArray.length) {
//            while (index < charArray.length && charArray[index] == ' ') index++;
//            int start = index; //一个单词的起点下标
//            while (index < charArray.length && charArray[index] != ' ') index++;
//            int end = index - 1; //一个单词的终点下标
//            //构造单词
//            if (start <= end) {
//                StringBuilder word = new StringBuilder();
//                for (int i = start; i <= end; i++) {
//                    word.append(charArray[i]);
//                }
//                list.add(String.valueOf(word));
//            }
//        }
//        String res = list.get(list.size() - 1);
//        for (String s1 : list) {
//            System.out.println(s1);
//        }
//        return res.length();
//    }

}
