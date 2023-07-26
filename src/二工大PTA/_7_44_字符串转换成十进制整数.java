package 二工大PTA;

import java.util.*;

public class _7_44_字符串转换成十进制整数 {
    private static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toLowerCase(); //全部转成小写
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>(); //存储十六进制字符
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            if ((cs[i] >= 'a' && cs[i] <= 'f')
                    || (cs[i] >= '0' && cs[i] <= '9')
                    || (cs[i] == '-' && stack.isEmpty())) {
                stack.push(cs[i]);
            }
        }
        int weight = 0;
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (c == '-') {
                res = -res;
            } else if (c >= '0' && c <= '9') {
                res += Integer.parseInt(c + "") * Math.pow(16, weight++);
            } else {
                //查字典
                Integer v = map.get(c);
                res += v * Math.pow(16, weight++);
            }
        }
        System.out.println(res);

    }
}
