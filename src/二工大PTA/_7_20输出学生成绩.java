package 二工大PTA;

import java.util.Scanner;

public class _7_20输出学生成绩 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }
        double max = 0, min = Double.MAX_VALUE, sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
            sum += scores[i];
        }
        System.out.printf("average = %.2f\nmax = %.2f\nmin = %.2f", sum / n, max, min);
    }
}
