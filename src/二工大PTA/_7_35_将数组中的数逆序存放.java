package 二工大PTA;

import java.util.Scanner;

public class _7_35_将数组中的数逆序存放 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
