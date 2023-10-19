package SaikrOJ;

import java.util.Scanner;

public class _4_IMissYou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        for (int i = 0; i < 7; i++) {
            res += sc.nextInt();
        }
        if (res > 0) {
            System.out.println("IMissYou!");
            System.out.println(res);
        } else {
            System.out.println("OvO");
        }

    }
}
