package 南邮OJ;

import java.util.Scanner;

/**
 * https://noj.njupt.edu.cn/problem/PROB1012
 */
public class _最小质数合数之和问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zs = 0;
        int hs = 0;
        //找大于n的最小质数
        for (int i = n + 1; ; i++) {
            if (isZhiShu(i)) {
                zs = i;
                break;
            }
        }
        //找最小合数
        for (int i = n + 1; ; i++) {
            if (!isZhiShu(i)) {
                hs = i;
                break;
            }
        }
        System.out.println(zs + hs);
    }

    //判断质数O(根号n)
    private static boolean isZhiShu(int v) {
        for (int i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

}
