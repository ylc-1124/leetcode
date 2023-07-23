package 二工大PTA;

import java.util.Scanner;
import java.util.Stack;

public class _7_9换硬币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 1; ; i++) { // 5分的数量
            if (5 * i > x) break;
            for (int j = 1; ; j++) { // 2分的数量
                if (5 * i + 2 * j > x) break;
                for (int k = 1; ; k++) { // 1分的数量
                    if (5 * i + 2 * j + k == x) {
                        String s = "fen5:" + i + ", fen2:" + j + ", fen1:" + k + ", total:" + (i + j + k);
                        stack.push(s);
                        count++;
                    } else if (5 * i + 2 * j + k > x) {
                        break;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("count = " + count);
    }
}
