package 南邮OJ;

import java.util.Scanner;

public class _南邮22机试B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        //初始化二维数组的值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //记录需要清0的行和列，rows[i]==1代表i行需要清零
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    //标记i行j列需要清零
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 1) {
                //将i行的m列清零
                for (int j = 0; j < m; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 1) {
                //将i列的n行清零
                for (int j = 0; j < n; j++) {
                    arr[j][i] = 0;
                }
            }
        }
        //打印结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
