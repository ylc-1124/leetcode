package 二工大PTA;

import java.util.Scanner;

public class _7_41_连续因子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max_len = 0; //连续因子的长度
        int start_num = 2; //连续因子起始数字

        //只关心连续因子
        for (int i = 2; i <= Math.sqrt(N); i++) {
            int len = 0; // 以i为起点的连续因子长度
            int sum = 1; //以i为起点的连续因子之积
            for (int j = i; ; j++) {
                sum *= j;
                if (N % sum == 0) {
                    len++;
                } else {
                    break;
                }
            }
            if (len > max_len) {
                max_len = len;
                start_num = i;
            }
        }

        System.out.println(max_len);
        for (int i = 0; i < max_len; i++) {
            if (i != max_len - 1) {
                System.out.print((start_num++) + "*");
            } else {
                System.out.print(start_num);
            }
        }
    }
}
