package 二工大PTA;

import java.util.Scanner;

public class _7_39计算阶乘和 {
    static int res = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        jiechen(n);
        System.out.println(res);
    }

    public static int jiechen(int v) {
        if (v < 2) return 1; // 1!没地方加到res中，所以初始化res时已经考虑了1!
        int ans = v * jiechen(v - 1);
        //将所有算过的阶乘结果累加起来
        res += ans;
        return ans;
    }
}
