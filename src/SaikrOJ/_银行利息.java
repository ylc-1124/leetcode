package SaikrOJ;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/29 14:22
 */
public class _银行利息 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lilv = sc.nextInt();
        int benjin = sc.nextInt();
        int num_years = sc.nextInt();

        while (num_years-- > 0) {
            int lirun = (int) (benjin * ((double)lilv / 100));
            benjin += lirun;
        }
        System.out.println(benjin);
    }
}
