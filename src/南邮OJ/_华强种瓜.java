package 南邮OJ;

import java.util.Scanner;

public class _华强种瓜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//瓜田的宽度
        int k = sc.nextInt();//洒水机的个数
        int r = sc.nextInt();//洒水机工作半径
        boolean[][] melon_field = new boolean[n][n];
        int[][] work_x_y = new int[k][2];
        for (int i = 0; i < work_x_y.length; i++) {
            work_x_y[i][0] = sc.nextInt(); //x坐标
            work_x_y[i][1] = sc.nextInt(); //y坐标
        }
        for (int i = 0; i < work_x_y.length; i++) {
            int x = work_x_y[i][0];
            int y = work_x_y[i][1];
            //标记洒水器能覆盖到的坐标
            coverScope(x, y, melon_field, r);
        }
        //查看覆盖了多少格子
        int count = 0;
        for (int i = 0; i < melon_field.length; i++) {
            for (int j = 0; j < melon_field[0].length; j++) {
                if (melon_field[i][j]) count++;
            }
        }
        System.out.println(count);
    }

    private static void coverScope(int x, int y, boolean[][] melon_field, int r) {
        int x_index = x - 1;
        int y_index = y - 1;
        melon_field[x_index][y_index] = true;
        //上下左右各能能覆盖r个格子，斜角各能覆盖r-1个格子
        //标记上下左右能覆盖的格子
        for (int i = 1; i < r + 1; i++) {
            judgeAndSet(x_index - i, y_index, melon_field);
            judgeAndSet(x_index + i, y_index, melon_field);
            judgeAndSet(x_index, y_index - i, melon_field);
            judgeAndSet(x_index, y_index + i, melon_field);
        }
        //标记斜方向能覆盖的格子
        for (int i = 1; i < r; i++) {
            judgeAndSet(x_index - i, y_index - i, melon_field);
            judgeAndSet(x_index - i, y_index + i, melon_field);
            judgeAndSet(x_index + i, y_index - i, melon_field);
            judgeAndSet(x_index + i, y_index + i, melon_field);
        }
    }

    private static void judgeAndSet(int x, int y, boolean[][] melon_field) {
        int n = melon_field.length;
        if (x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1) {
            melon_field[x][y] = true;
        }
    }
}
