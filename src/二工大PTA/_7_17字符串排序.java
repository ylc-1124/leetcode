package 二工大PTA;

import java.util.Arrays;
import java.util.Scanner;

public class _7_17字符串排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[5];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sc.next();
        }
        Arrays.sort(strs);
        System.out.println("After sorted:");
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
