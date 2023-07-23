package 二工大PTA;

import java.util.Scanner;
import java.util.Stack;

public class _7_8输出整数各位数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.print(0 + " ");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            int digit = n % 10;
            stack.push(digit);
            n /= 10;
        }
        while (!stack.isEmpty()) {
            Integer digit = stack.pop();
            System.out.printf("%d ", digit);
        }
    }
}
