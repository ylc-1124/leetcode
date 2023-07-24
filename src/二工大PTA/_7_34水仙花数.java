package 二工大PTA;

import java.util.Scanner;

public class _7_34水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (isShuiXianHua(i, n)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isShuiXianHua(int v, int n) {
        int copy_v = v;
        int sum = 0;
        while (v != 0) {
            int digit = v % 10;
            sum += Math.pow(digit, n);
            if (sum > copy_v) return false;
            v /= 10;
        }
        return sum == copy_v;
    }
}
