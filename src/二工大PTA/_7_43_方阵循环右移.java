package 二工大PTA;

import java.util.Scanner;

public class _7_43_方阵循环右移 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 循环右移m列
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[] tmp = new int[n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //循环右移m列
        for (int i = 0; i < m; i++) {
            //保存最后一列
            for (int j = 0; j < n; j++) {
                tmp[j] = arr[j][n - 1];
            }
            //循环右移一列
            for (int col = n - 2; col >= 0; col--) {
                for (int row = 0; row < n; row++) {
                    arr[row][col + 1] = arr[row][col];
                }
            }
            for (int row = 0; row < n; row++) {
                arr[row][0] = tmp[row];
            }
        }
        //打印结果
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
