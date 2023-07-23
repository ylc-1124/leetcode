package 二工大PTA;

import java.util.Scanner;

public class _7_25英文字母替换加密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    cs[i] = 'A';
                } else {
                    cs[i] = (char) Character.toUpperCase(c + 1);
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    cs[i] = 'a';
                } else {
                    cs[i] = (char) Character.toLowerCase(c + 1);
                }
            }
        }
        System.out.println(String.valueOf(cs));
    }
}
