package 二工大PTA;

import java.util.Scanner;

public class _7_18正整数A加B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String C = sc.nextLine();//接收多余部分

        String res = "";
        int A_value = -1, B_value = -1;
        try {
            A_value = Integer.parseInt(A);
            if (A_value < 1 || A_value > 10000) {
                throw new NumberFormatException();
            } else {
                res += A_value +" + ";
            }
        } catch (NumberFormatException e) {
            res += "? + ";
        }
        try {
            if (C.length() > 1) {
                //不算空格还有有多余内容
                res += "? = ";
            } else {
                B_value = Integer.parseInt(B);
                if (B_value < 1 || B_value > 10000) {
                    throw new NumberFormatException();
                } else {
                    res += B_value + " = ";
                }
            }
        } catch (NumberFormatException e) {
            res += "? = ";
        }
        if (A_value != -1 && B_value != -1) {
            int x = A_value + B_value;
            res += x;
        } else {
            res += "?";
        }
        System.out.println(res);
    }
}
