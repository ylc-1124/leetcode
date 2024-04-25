package chuanzhi;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/17 15:31
 */
public class _1_赝品 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 商品总数
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max_count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq + 1);
            if (freq + 1 > max_count) {
                max_count = freq + 1;
            }
        }
        List<Integer> yanpinList = new ArrayList<>();

        for (Integer i : map.keySet()) {
            if (map.get(i) != max_count) {
                // 赝品
                yanpinList.add(i);
            }
        }
        yanpinList.sort((o1, o2) -> o1 - o2);
        System.out.println(yanpinList.size());
        for (Integer i : yanpinList) {
            System.out.print(i + " ");
        }


    }
}
