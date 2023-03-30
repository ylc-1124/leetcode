package 南邮OJ;

import java.util.Scanner;

public class _级数求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        double s = 0;
        for (double i = 1; ; i++) {
            s += (1 / i);
            if (s > k) {
                System.out.println((int)i);
                break;
            }
        }
    }
}
