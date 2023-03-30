package 南邮OJ;

import java.util.HashSet;
import java.util.Scanner;

public class _小明的记忆游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //主持人给出n个数字
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int m = sc.nextInt(); //询问m个数字
        int[] asks = new int[m];
        for (int i = 0; i < asks.length; i++) {
            asks[i] = sc.nextInt();
        }
        for (int i = 0; i < asks.length; i++) {
            if (set.contains(asks[i])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
