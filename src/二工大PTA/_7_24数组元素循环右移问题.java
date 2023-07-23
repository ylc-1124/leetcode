package 二工大PTA;

import java.util.Scanner;

public class _7_24数组元素循环右移问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int tmp = arr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                arr[j + 1] =arr[j];
            }
            arr[0] = tmp;
        }
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i]);
            }
        }

    }
}
