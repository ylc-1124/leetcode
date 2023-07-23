package 二工大PTA;

import java.util.Scanner;

public class _7_13计算圆周率 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double threshold = sc.nextDouble();
        double sum = 0.0;
        double a = 1.0; //分母
        for (int i = 0; ; i++) {
            double b = factor(i) / a;
            sum += b;
            if (b < threshold) break;
            a *= (2 * i + 3);
        }
        System.out.printf("%.6f", sum * 2);
    }

    public static Long factor(int i) {
        if (i == 0) return 1L;
        return i * factor(i - 1);
    }
}
