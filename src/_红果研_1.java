import java.util.Scanner;
import java.util.Stack;

/**
 * 回文整数
 */
public class _红果研_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer x = sc.nextInt();
        String s = x.toString();
        char[] s1 = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s1.length; i++) {
            stack.push(s1[i]);
        }
        for (int i = 0; i < s1.length; i++) {
            if (!stack.pop().equals(s1[i])) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
