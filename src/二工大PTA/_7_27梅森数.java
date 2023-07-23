package 二工大PTA;

import java.util.Scanner;

public class _7_27梅森数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;
        for (int i = 2; i <= n; i++) {
            int v = (int) (Math.pow(2, i) - 1);
            if (isSuShu(v)) {
                flag = false;
                System.out.println(v);
            }
        }
        if (flag) {
            System.out.println("None");
        }
    }
    private static boolean isSuShu(int n) {
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
