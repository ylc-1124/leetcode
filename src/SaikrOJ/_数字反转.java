package SaikrOJ;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/29 13:52
 */
public class _数字反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n < 0) {
            System.out.print("-");
            n = -n;
        }
        // n 为正数了
        String n_str = String.valueOf(n);

        // 颠倒字符串
        char[] cs = n_str.toCharArray();
        for (int left = 0; left < cs.length >> 1; left++) {
            int right = cs.length - 1 - left;
            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
        }

        // 解析成数字
        boolean flag = false; // 是否解析出首位数字（首位不能为0）
        for (int i = 0; i < cs.length; i++) {
            if (!flag && cs[i] == '0') continue;
            System.out.print(cs[i]);
            flag = true;
        }

    }
}
