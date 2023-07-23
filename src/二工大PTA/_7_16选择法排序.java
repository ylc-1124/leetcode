package 二工大PTA;

import java.util.Scanner;

public class _7_16选择法排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //选择排序
        for (int i = 0; i < arr.length; i++) {
            int max_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max_index]) {
                    max_index = j;
                }
            }
            if (max_index != i) {
                //交换
                int tmp = arr[i];
                arr[i] = arr[max_index];
                arr[max_index] = tmp;
            }
        }
        //打印
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
