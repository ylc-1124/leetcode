package ccf;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2024/2/1 15:36
 */
public class e_等式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;

        // 找比 n小的质数有哪些
        for (int i = 2; i < n; i++) { // C=i
            if (!isZhiShu(i) || isZhiShu(n - i)) continue; // AxB=n-i

            int d = n - i;
            res += countHeShuFenJie(d);
        }

        System.out.println(res);
    }

    // 判断质数
    private static boolean isZhiShu(int n) {
        if (n == 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countHeShuFenJie(int n) {
        if (n == 1) return 1;

        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return (count + 1) << 1;
    }
}
