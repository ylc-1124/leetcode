package 二工大PTA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _7_29_2800_垂直直方图 {

    public static Map<Character, Integer> map = new HashMap<>();
    public static int max = Integer.MIN_VALUE;

    static {
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            map.put(c, 0);
            c += 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        countChar(s1);
        countChar(s2);
        countChar(s3);
        countChar(s4);
        if (max == Integer.MIN_VALUE) {
            System.out.print("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
            return;
        }
        //画垂直直方图
        char[][] charArr = new char[max + 1][26];
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            //填字母
            charArr[max][i] = c;
            //填出现次数（用星星表示）
            int count = map.get(c);
            for (int j = 1; j <= count; j++) {
                charArr[max - j][i] = '*';
            }
            //填空白
            for (int j = count + 1; j <= max; j++) {
                charArr[max - j][i] = ' ';
            }
            c += 1;
        }
        //打印图
        for (int i = 0; i < charArr.length; i++) {
            if (i != charArr.length - 1) {
                for (int j = 0; j < charArr[0].length; j++) {
                    System.out.print(charArr[i][j] + " ");
                }
                System.out.println();
            } else {
                //字母打印特殊一些
                for (int j = 0; j < charArr[0].length; j++) {
                    if (j != charArr[0].length - 1) {
                        System.out.print(charArr[i][j] + " ");
                    } else {
                        System.out.print(charArr[i][j]);
                    }
                }
            }
        }
    }

    private static void countChar(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'A' && cs[i] <= 'Z') {
                int count = map.get(cs[i]);
                count++;
                map.put(cs[i], count);
                if (count > max) {
                    max = count;
                }
            }
        }
    }
}
