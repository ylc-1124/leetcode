package 二工大PTA;

import java.util.Scanner;

public class _7_15求矩阵的局部极大值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean flag = true;
        //遍历所有非边界元素
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                int cur = arr[i][j];
                if (cur > arr[i - 1][j]
                        && cur > arr[i + 1][j]
                        && cur > arr[i][j - 1]
                        && cur > arr[i][j + 1]) {
                    flag = false;
                    System.out.printf("%d %d %d\n", cur, i + 1, j + 1);
                }
            }
        }
        if (flag) {
            System.out.println("None " + rows + " " + cols);
        }
    }
}
