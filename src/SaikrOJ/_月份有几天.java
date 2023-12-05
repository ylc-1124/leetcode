package SaikrOJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/29 13:44
 */
public class _月份有几天 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        if (month == 2) {
            if (isRunYear(year)) {
                System.out.println(29);
            } else {
                System.out.println(28);
            }

        } else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                System.out.println(31);
            } else {
                System.out.println(30);
            }
        }


    }

    private static boolean isRunYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
