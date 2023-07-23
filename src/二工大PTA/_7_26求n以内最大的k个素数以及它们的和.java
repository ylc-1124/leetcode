package 二工大PTA;

import java.util.*;

public class _7_26求n以内最大的k个素数以及它们的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0; // 最大k个素数的和
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isSuShu(i)){
                list.add(i);
            }
        }
        list.sort(((o1, o2) -> o2 - o1));
        int lim = Math.min(k, list.size());
        for (int i = 0; i < lim; i++) {
            if (i != lim - 1) {
                System.out.print(list.get(i) + "+");
            } else {
                System.out.print(list.get(i) + "=");
            }
            sum += list.get(i);
        }
        System.out.print(sum);
    }

    private static boolean isSuShu(int n) {
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
