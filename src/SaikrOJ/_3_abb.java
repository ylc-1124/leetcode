package SaikrOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/26 15:52
 */
public class _3_abb {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        String str = sc.next();
//        int res = 0;
//        for (int i = str.length() - 1; i >= 0; i--) {
//            int j = i - 1;
//            while (j >= 0 && str.charAt(j) != str.charAt(i)) j--;
//            if (j <= 0) continue;
//
//            Queue<Integer> queue = new LinkedList<>();
//            queue.add(j);
//            while (!queue.isEmpty()) {
//                Integer idx = queue.poll();
//                for (int k = idx - 1; k >= 0; k--) {
//                    if (str.charAt(k) != str.charAt(i)) {
//                        res++;
//                    } else {
//                        // 记录下一个 j的位置
//                        queue.add(k);
//                    }
//                }
//            }
//        }
//
//        System.out.println(res);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        long res = 0;

        // 后缀和数组，suffix[i+1][j]表示str中第 i个字母之后对应字母出现的次数
        int[][] suffix = new int[n + 1][26];
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            for (int j = 0; j < 26; j++) {
                suffix[i][j] = suffix[i + 1][j];
            }
            suffix[i][c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (j != c - 'a' && suffix[i][j] >= 2) {
                    res += suffix[i + 1][j] * (suffix[i + 1][j] - 1) / 2;
                }
            }
        }

        System.out.println(res);
    }
}
