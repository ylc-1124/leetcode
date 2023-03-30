package 南邮OJ;

import java.util.Scanner;
import java.util.Stack;

public class _南邮_新对称素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //接收n个元素
        long [] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
        //判断是否是新对称素数
        for (int i = 0; i < arr.length; i++) {
            long v = arr[i];
            if (String.valueOf(v).length() > 5
                    || !isSuShu(v)
                    || !isMirror(String.valueOf(v))) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    //双指针法判断回文字符串 O(n)
    private static boolean isMirror(String s) {
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

    //判断素数  时间复杂度：O(根号n)
    private static boolean isSuShu(long v) {
        if (v < 2) return false;
        for (long i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }
    // 栈判断回文
//    private static boolean isMirror(String s) {
//        char[] charArray = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < charArray.length; i++) {
//            stack.push(charArray[i]);
//        }
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] != stack.pop()) return false;
//        }
//
//        return true;
//    }
}
