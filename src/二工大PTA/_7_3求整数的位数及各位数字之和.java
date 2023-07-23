package 二工大PTA;

import java.util.Scanner;

public class _7_3求整数的位数及各位数字之和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, count = 0;
        while (n != 0) {
            int d = n % 10;
            count++; //位数
            sum += d; //各位之和
            n /= 10;
        }
        System.out.printf("%d %d", count, sum);
    }
}
