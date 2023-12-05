package SaikrOJ;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/3 10:30
 */
public class _排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            long n = sc.nextLong();
            long res = 0;
            if (n == 2) {
                System.out.println(1);
                continue;
            }
            // 1, 2, ..., n
            // {1,2..n/2} {n/2+1 ...n}
            long tmp = n / 2;
            long left = tmp + 1, right = n;
            for (long cur = 1; cur <= tmp && right >= tmp + 2; cur++) {
                res += (left - cur);
                res += (right - cur);

                left = right;
                right--;
            }
            if (n % 2 == 0) {
                res += 2;
            }


            System.out.println(res);

        }
    }
}
