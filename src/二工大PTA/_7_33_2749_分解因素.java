package 二工大PTA;

import java.util.Scanner;

public class _7_33_2749_分解因素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            System.out.println(fenjie(num, 2) + 1);
        }
    }

    public static int fenjie(int num, int start) {
        if (num < 4) return 0;
        int count = 0;
        for (int i = start; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++; // 算上一种
                count += fenjie(num / i, i); // 看看商还能不能满足分解条件
            }
        }
        return count;
    }
}
