package 二工大PTA;

import java.util.Scanner;

public class _7_19凯撒密码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int offset = sc.nextInt();
        // 将负步数变成等价的正步数
        while (offset < 0) {
            offset += 26;
        }
        while (offset > 26) {
            offset -= 26;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z')) {
                chars[i] = (char) ('a' + (chars[i] - 'a' + offset) % 26);
            } else if ((chars[i] >= 'A' && chars[i] <= 'Z')) {
                chars[i] = (char) ('A' + (chars[i] - 'A' + offset) % 26);
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
