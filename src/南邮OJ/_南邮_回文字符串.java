package 南邮OJ;

import java.util.Scanner;

public class _南邮_回文字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (isMirror(s.toLowerCase())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isMirror(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;
    }
}
