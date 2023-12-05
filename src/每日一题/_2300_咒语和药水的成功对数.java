package 每日一题;

import java.util.Arrays;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/10 21:53
 */
public class _2300_咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length; // 咒语的数量
        int[] pairs = new int[n];
        // 对药水强度排序
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int cur = spells[i]; // 当前咒语的强度
            int idx = binary_search(potions, cur, success);
            int success_pair = potions.length - idx;
            pairs[i] = success_pair;
        }

        return pairs;
    }

    /**
     * 找到最左边的 arr[i]使得 cur * arr[i] >= success
     * @return 下标 i
     */
    private int binary_search(int[] arr, int cur, long success) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((long) cur * arr[mid] < success) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
