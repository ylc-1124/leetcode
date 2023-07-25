package 二工大PTA;

import java.util.Scanner;
import java.util.Stack;

public class _7_40打印沙漏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.next();
        if (n <= 0) return;
        if (n < 7) {
            System.out.println(c);
            System.out.println(n - 1);
            return;
        }
        int a = 0; // 打印的层数
        for (int i = 1; ; i++) {
            int need = i * i * 2 - 1;
            if (need > n) {
                a = i - 1;
                break;
            }
        }
        a--;
        int tmp = a;
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();
        int num = 3;
        while (a-- > 0) {
            stack_1.push(num);
            num += 2;
        }
        // 总共需要打印多少个字符
        Integer b = stack_1.peek();
        int all = (3 + b) * tmp >> 1;
        all = all * 2 + 1;
        // 打印沙漏上半部分
        int num_kg = 0;
        while (!stack_1.isEmpty()) {
            Integer num_c = stack_1.pop();
            stack_2.push(num_c);
            for (int i = 0; i < num_kg; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < num_c; i++) {
                System.out.print(c);
            }
            System.out.println();
            num_kg++;
        }
        //打印沙漏的中心
        for (int i = 0; i < num_kg; i++) {
            System.out.print(" ");
        }
        System.out.println(c);
        num_kg--;
        // 打印沙漏下半部分
        while (!stack_2.isEmpty()) {
            Integer num_c = stack_2.pop();
            for (int i = 0; i < num_kg; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < num_c; i++) {
                System.out.print(c);
            }
            System.out.println();
            num_kg--;
        }
        // 打印剩余未使用的字符数
        if (n - all != 0) {
            System.out.println(n - all);
        }
    }
}
