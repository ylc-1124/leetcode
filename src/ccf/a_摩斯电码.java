package ccf;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2024/2/1 14:15
 */
public class a_摩斯电码 {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("01", "A");
        map.put("1000", "B");
        map.put("1010", "C");
        map.put("100", "D");
        map.put("0", "E");
        map.put("0010", "F");
        map.put("110", "G");
        map.put("0000", "H");
        map.put("00", "I");
        map.put("0111", "J");
        map.put("101", "K");
        map.put("0100", "L");
        map.put("11", "M");
        map.put("10", "N");
        map.put("111", "O");
        map.put("0110", "P");
        map.put("1101", "Q");
        map.put("010", "R");
        map.put("000", "S");
        map.put("1", "T");
        map.put("001", "U");
        map.put("0001", "V");
        map.put("011", "W");
        map.put("1001", "X");
        map.put("1011", "Y");
        map.put("1100", "Z");
        map.put("01111", "1");
        map.put("00111", "2");
        map.put("00011", "3");
        map.put("00001", "4");
        map.put("00000", "5");
        map.put("10000", "6");
        map.put("11000", "7");
        map.put("11100", "8");
        map.put("11110", "9");
        map.put("11111", "0");
        map.put("001100", "?");
        map.put("10010", "/");
        map.put("101101", "()");
        map.put("100001", "-");
        map.put("010101", ".");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();

        // 将 . 换成 ,
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') {
                str.append(s.charAt(i));
            } else {
                str.append(",");
            }
        }

        String[] strs = str.toString().split(",");
        for (String ss : strs) {
            sb.append(map.get(ss));
        }

        System.out.println(sb);
    }

}
