package 南邮OJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _斐波那契数列 {
    //带备忘录的递归写法
    private static Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fn = fib(n);
        System.out.println(fn);
    }

    private static int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        //检查缓存
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        int fn = fib(n - 1) + fib(n - 2);
        memo.put(n, fn);
        return fn;
    }

}
