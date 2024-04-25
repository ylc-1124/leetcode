package 每日一题;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ylc
 * @date: 2024/1/31 12:12
 */
public class _2670_找出不同元素数目差数组 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        // nums[0...i] 中不同的元素有 left[i]个
        int[] left = new int[n];
        // nums[i+1...n-1] 中不同的元素有 right[i]个
        int[] right = new int[n];

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                count++;
                set.add(nums[i]);
            }
            left[i] = count;
        }

        set.clear();
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = count;
            if (!set.contains(nums[i])) {
                count++;
                set.add(nums[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            diff[i] = left[i] - right[i];
        }

        return diff;
    }

}
