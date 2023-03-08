import java.util.Scanner;

/**
 * 求大于n的最小质数和最小合数之和
 */
public class _南邮21机试 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zs = 0, hs = 0;
        //找出最小质数
        for (int i = n + 1; ; i++) {
            if (isZS(i)) {
                zs = i;
                break;
            }
        }
        //找出最小合数
        for (int i = n + 1; ; i++) {
            if (!isZS(i)) {
                hs = i;
                break;
            }
        }
        System.out.println(zs + hs);
    }

    private static boolean isZS(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
