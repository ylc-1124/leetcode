package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = map.getOrDefault(target - nums[i], -1);
            if (index != -1) return new int[]{i, index};

            map.put(nums[i], i);
        }
        return new int[0];
    }
}
