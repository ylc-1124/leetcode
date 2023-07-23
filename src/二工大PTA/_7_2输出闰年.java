package 二工大PTA;

import java.util.Scanner;

public class _7_2输出闰年 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        if (end <= 2000 || end >= 2100) {
            System.out.println("Invalid year!");
            return;
        }
        boolean flag = true; //是否需要打印 None
        for (int year = 2004; year <= end; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                flag = false;
                System.out.println(year);
            }
        }
        if (flag) {
            System.out.println("None");
        }
    }
}
