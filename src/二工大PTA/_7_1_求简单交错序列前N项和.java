package 二工大PTA;

import java.util.Scanner;

public class _7_1_求简单交错序列前N项和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double sum = 0.0;
        int a = 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sum += 1.0 / a;

            } else {
                sum -= 1.0 / a;
            }
            a += 3;
        }
        System.out.printf("sum = %.3f", sum);
    }
}
