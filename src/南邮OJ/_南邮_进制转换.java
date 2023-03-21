package 南邮OJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class _南邮_进制转换 {
    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n组数据
        int[][] arr = new int[n][2];
        //接收输入的数据
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        //进制转换
        for (int i = 0; i < arr.length; i++) {
            int N = arr[i][0];
            boolean flag = false;
            if (N < 0) {
                flag = true; //结果加个负号
                N = Math.abs(N);
            }
            int R = arr[i][1];
            //把十进制数N转换成R进制数
            Stack<String> stack = new Stack<>();
            while (N / R != 0) {
                stack.push(convert(N % R));
                N = N / R;
            }
            stack.push(convert(N % R));
            //拼接结果
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            if (flag) { //原来是负数结果加个负号
                sb.insert(0, "-");
            }
            System.out.println(sb);
        }
    }

    private static String convert(int v) {
        if (v > 9) {
            return map.get(v);
        } else {
            return String.valueOf(v);
        }
    }
}
