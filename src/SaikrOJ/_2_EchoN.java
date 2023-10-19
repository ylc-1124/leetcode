package SaikrOJ;

import java.util.Scanner;

public class _2_EchoN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] cs = s.toCharArray();
        int res = 0;

        for (int count = 1; count <= cs.length; count++) {
            String template = String.valueOf(cs, 0, count);
            int freq = counter(template, s);
            if (freq != 1) {
                res += freq;
            } else {
                res += cs.length - count + 1;
                break;
            }
        }

        System.out.println(res);
    }

    /**
     * 统计字符串 template在 s中出现的次数
     */
    public static int counter(String template, String s) {
        int len = template.length();
        int count = 0;
        for (int i = 0; i <= s.length() - len; i++) {
            if (template.charAt(0) == s.charAt(i)) {
                String sb = s.substring(i, i + len);
                if (sb.equals(template)) {
                    count++;
                }
            }
        }
        return count;
    }
}
