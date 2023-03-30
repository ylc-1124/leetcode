package 南邮OJ;

import java.util.Scanner;
import java.util.Stack;

public class _最大公约数和最小公倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int gys = max_gys(A, B);
        int gbs = A * B / gys;   //min_gbs(A, B)
        System.out.println(gys + " " + gbs);
    }

//    //求a，b的最小公倍数
//    private static int min_gbs(int a, int b) {
//        int[] beiShu_a = new int[b + 1]; //存储a的1~b倍 a[i]是a的i倍
//        int[] beiShu_b = new int[a + 1]; //存储b的1~a倍
//        //求a的1~b倍
//        for (int i = 1; i <= b; i++) {
//            beiShu_a[i] = a * i;
//        }
//        //求b的1~a倍
//        for (int i = 1; i <= a; i++) {
//            beiShu_b[i] = b * i;
//        }
//        //找到最小公倍数
//        int pa = 1, pb = 1;
//        while (beiShu_a[pa] != beiShu_b[pb]) {
//            if (beiShu_a[pa] < beiShu_b[pb]) {
//                pa++;
//            } else {
//                pb++;
//            }
//        }
//        return beiShu_a[pa];
//    }


    //求a，b的最大公约数
    private static int max_gys(int a, int b) {
        Stack<Integer> stack_a = yueShu(a);
        Stack<Integer> stack_b = yueShu(b);
        while (!stack_a.peek().equals(stack_b.peek())) {
            if (stack_a.peek() > stack_b.peek()) {
                stack_a.pop();
            } else {
                stack_b.pop();
            }
        }
        return stack_a.peek();
    }

    /**
     * 求x的约数
     *
     * @param x
     * @return 存放x约数的栈
     */
    private static Stack<Integer> yueShu(int x) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                stack.push(i);
            }
        }
        return stack;
    }

}
