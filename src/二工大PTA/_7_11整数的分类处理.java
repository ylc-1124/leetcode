package 二工大PTA;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class _7_11整数的分类处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A1 = Integer.MIN_VALUE, A2 = 0;
        double A3 = 0.0;
        double sum = 0; // 满足A3的整数之和
        int count = 0; // 满足A3的整数的个数
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (v % 3 == 0 && v > A1) {
                A1 = v;
            }
            if ((v - 1) % 3 == 0) {
                A2++;
            }
            if ((v - 2) % 3 == 0) {
                sum += v;
                count++;
            }
        }
        if (A1 == Integer.MIN_VALUE) {
            System.out.print("NONE ");
        } else {
            System.out.print(A1 + " ");
        }
        if (A2 == 0) {
            System.out.print("NONE ");
        } else {
            System.out.print(A2 + " ");
        }
        if (count == 0) {
            System.out.print("NONE");
        } else {
            A3 = sum / count;
            System.out.printf("%.1f", A3);
        }

    }
}
