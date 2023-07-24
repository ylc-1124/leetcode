package 二工大PTA;

import java.util.Scanner;

public class _7_38掉入陷阱的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = n;
        for (int i = 1; ; i++) {
            int cur = 0;
            while (n != 0) {
                int digit = n % 10;
                cur += digit;
                n /= 10;
            }
            cur = 3 * cur + 1;
            System.out.printf("%d:%d\n", i, cur);
            if (last == cur) {
                break;
            } else {
                last = cur;
                n = cur;
            }
        }
    }
}
