import java.util.Arrays;
import java.util.Scanner;

public class _南邮22机试A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[n - 1] + arr[n - 2] + arr[n - 3]);
    }
}
