package 二工大PTA;

import java.util.*;

public class _7_14求一批整数中出现最多的个位数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (v == 0) {
                //如果输入的值就是0
                Integer j = map.getOrDefault(v, 0);
                map.put(v, j + 1);
                if ((j + 1) > maxCount) {
                    maxCount = j + 1;
                }
            }
            while (v != 0) {
                int digit = v % 10;
                Integer j = map.getOrDefault(digit, 0);
                map.put(digit, j + 1);
                if ((j + 1) > maxCount) {
                    maxCount = j + 1;
                }
                v /= 10;
            }
        }
        Set<Integer> keys = map.keySet();
        List<Integer> res = new ArrayList<>();
        for (Integer key : keys) {
            if (map.get(key) == maxCount) {
                res.add(key);
            }
        }
        Collections.sort(res);
        System.out.print(maxCount + ":");
        for (Integer num : res) {
            System.out.print(" " + num);
        }
        System.out.println();
    }
}
