package 二工大PTA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _7_5输出大写英文字母 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z' && !set.contains(c)) {
                System.out.print(c);
                set.add(c); //打印过的大写字母放入set中
            }
        }
        if (set.isEmpty()) {
            System.out.println("Not Found");
        }
    }
}
