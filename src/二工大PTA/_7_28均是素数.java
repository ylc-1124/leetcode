package 二工大PTA;

import java.util.Scanner;

public class _7_28均是素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count = 0;
        for (int p = m; p <= n; p++) {
            if (!isSuShu(p)) continue;
            for (int q = p + 1; q <= n; q++) {
                if (!isSuShu(q)) continue;
                for (int r = q + 1; r <= n; r++) {
                    if (!isSuShu(r)) continue;
                    if (isSuShu(p * q + r)
                            && isSuShu(q * r + p)
                            && isSuShu(r * p + q)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    //判断素数  时间复杂度：O(根号n)
    private static boolean isSuShu(int v) {
        if (v < 2) return false;
        for (int i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }
}
