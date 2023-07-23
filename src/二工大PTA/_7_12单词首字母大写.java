package 二工大PTA;

import java.util.Arrays;
import java.util.Scanner;

public class _7_12单词首字母大写 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            while (index < chars.length && chars[index] == ' ') index++;
            if (index < chars.length &&
                    chars[index] >= 'a' && chars[index] <= 'z') chars[index] = Character.toUpperCase(chars[index]);
            while (index < chars.length && chars[index] != ' ') index++;
        }
        System.out.printf(String.valueOf(chars));
    }
}
