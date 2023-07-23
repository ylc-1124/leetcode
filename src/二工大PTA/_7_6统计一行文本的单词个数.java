package 二工大PTA;

import java.util.Scanner;

public class _7_6统计一行文本的单词个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = 0, res = 0;
        while (i < s.length()) {
            // 找首字母
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (i < s.length())  res++;
            //使i走过整个单词，指向末尾后一个位置
            while (i < s.length() && s.charAt(i) != ' ') i++;
        }
        System.out.println(res);
    }
}
