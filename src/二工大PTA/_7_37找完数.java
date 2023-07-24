package 二工大PTA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class _7_37找完数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean flag = true;
        for (int i = m; i <= n; i++) {
            int sum = 1; // 元素i除自身外的因子和
            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // j是i的因子
                    sum += j;
                }
            }
            if (sum == i) {
                // 完数
                flag = false;
                System.out.print(i + " = 1");
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) { // j是i的因子
                        System.out.print(" + " + j);
                    }
                }
                System.out.println();
            }
        }
        if (flag) {
            System.out.println("None");
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        boolean flag = true;
//        for (int i = m; i <= n; i++) {
//            List<Integer> list = new ArrayList<>(); // 保存元素i除1和自身以外的其他因子
//            int sum = 1; // 元素i除自身外的因子和
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) { // j是i的因子
//                    sum += j;
//                    list.add(j);
//                }
//            }
//            if (sum == i) {
//                // 完数
//                flag = false;
//                System.out.print(i + " = 1");
//                for (Integer factor : list) {
//                    System.out.print(" + " + factor);
//                }
//                System.out.println();
//            }
//        }
//        if (flag) {
//            System.out.println("None");
//        }
//    }
}
