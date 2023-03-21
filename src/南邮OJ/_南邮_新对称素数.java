package 南邮OJ;

import java.util.Scanner;
import java.util.Stack;

public class _南邮_新对称素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //接收n个元素
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //判断是否是新对称素数
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (String.valueOf(v).length() > 5
                    || !isSuShu(v)
                    || !isMirror(String.valueOf(v))) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    //判断回文字符串 O(n)
    private static boolean isMirror(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != stack.pop()) return false;
        }
        return true;
    }

    //判断素数  时间复杂度：O(根号n)
    private static boolean isSuShu(int v) {
        if (v < 2) return false;
        for (int i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }
}
