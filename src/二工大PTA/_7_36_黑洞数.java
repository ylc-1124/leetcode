package 二工大PTA;

import java.util.Arrays;
import java.util.Scanner;

public class _7_36_黑洞数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[3];
        int index = 0;
        for (int i = 1; ; i++) {
            // 取n各个位置的元素
            while (n != 0) {
                int digit = n % 10;
                arr[index++] = digit;
                n /= 10;
            }
            Arrays.sort(arr);
            int left = 0, right = 0, beishu = 1;
            for (int j = 0; j < 3; j++) {
                left += beishu * arr[j];
                right += beishu * arr[arr.length - 1 - j];
                beishu *= 10;
            }
            System.out.printf("%d: %d - %d = %d\n", i, left, right, left - right);
            if (left - right == 495 || left - right == 0) {
                break;
            } else {
                n = left - right;
                index = 0;
            }
        }
    }
}
