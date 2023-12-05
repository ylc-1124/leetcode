package SaikrOJ;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/29 13:41
 */
public class _判断一个数能否同时被3和5整除 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
