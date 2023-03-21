package 南邮OJ;

import java.util.Scanner;

public class _小明喝可乐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = n;
        while (n / k != 0) {
            int bottle = n / k;//空瓶可以换得的可乐数
            int remain = n % k;//剩余的空瓶数
            res += bottle;
            n = bottle + remain;//可用于兑换可乐的空瓶数
        }
        System.out.println(res);
    }
}
