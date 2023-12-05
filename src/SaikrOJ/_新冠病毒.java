package SaikrOJ;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/3 9:13
 */
public class _新冠病毒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // 天数
        BigInteger big_n = new BigInteger(String.valueOf(n));
        BigInteger sum = big_n.multiply(new BigInteger(String.valueOf(n + 1))).divide(new BigInteger(String.valueOf(2)));
        System.out.println(sum.toString());
        System.out.println(sum.divide(big_n).toString());
    }
}
