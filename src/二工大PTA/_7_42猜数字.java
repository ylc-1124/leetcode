package 二工大PTA;

import java.util.Arrays;
import java.util.Scanner;

public class _7_42猜数字 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Friend[] fs = new Friend[n + 1];
//        int sum = 0, target = 0;
//        for (int i = 0; i < n; i++) {
//            Friend f = new Friend();
//            f.name = sc.next();
//            f.num = sc.nextInt();
//            fs[i] = f;
//            sum += f.num;
//        }
//        target = sum / (2 * n);
//        Friend f_target = new Friend();
//        f_target.name = "meanDiv2";
//        f_target.num = target;
//        fs[n] = f_target;
//        Arrays.sort(fs, (o1, o2) -> o1.num - o2.num);
//        int index = -1;
//        for (int i = 0; i < n + 1; i++) {
//            if ("meanDiv2".equals(fs[i].name)) {
//                index = i;
//            }
//        }
//        int left = -1, right = -1;
//        if (index - 1 >= 0) {
//            left = Math.abs(fs[index - 1].num - target);
//        }
//        if (index + 1 <= n) {
//            right = Math.abs(fs[index + 1].num - target);
//        }
//        String winner = "";
//        if (left != -1 && right != -1) {
//            winner = left > right ? fs[index + 1].name : fs[index - 1].name;
//        } else if (left == -1) {
//            winner = fs[index + 1].name;
//        } else {
//            winner = fs[index - 1].name;
//        }
//        System.out.printf("%d %s\n", target, winner);
//
//    }
//
//    static class Friend {
//        public String name;
//        public int num;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] names = new String[n];
//        int[] nums = new int[n];
//        int sum = 0, target = 0;
//        for (int i = 0; i < n; i++) {
//            String name = sc.next();
//            int num = sc.nextInt();
//            names[i] = name;
//            nums[i] = num;
//            sum += num;
//        }
//        target = sum / (2 * n);
//        String winnerName = names[0];
//        int winnerNum = nums[0];
//        for (int i = 1; i < n; i++) {
//            if (Math.abs(nums[i] - target) < Math.abs(winnerNum - target)) {
//                winnerName = names[i];
//                winnerNum = nums[i];
//            }
//        }
//        System.out.printf("%d %s\n", target, winnerName);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Map<String, Integer> map = new HashMap<>();
//        int sum = 0, target = 0;
//        for (int i = 0; i < n; i++) {
//            String name = sc.next();
//            int num = sc.nextInt();
//            map.put(name, num);
//            sum += num;
//        }
//        target = sum / (2 * n);
//        String winnerName = "";
//        int winnerNum = Integer.MIN_VALUE;
//        for (String name : map.keySet()) {
//            Integer a = map.get(name);
//            if (Math.abs(a - target) < Math.abs(winnerNum - target)) {
//                winnerName = name;
//                winnerNum = a;
//            }
//        }
//        System.out.printf("%d %s\n", target, winnerName);
//    }
}
