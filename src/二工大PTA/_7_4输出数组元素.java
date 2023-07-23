package 二工大PTA;

import java.util.Scanner;

public class _7_4输出数组元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr2[i] = arr[i + 1] - arr[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            if (i == arr2.length - 1 || (i + 1) % 3 == 0) {
                System.out.println(arr2[i]);
            } else {
                System.out.printf("%d ", arr2[i]);
            }
        }
    }
}
