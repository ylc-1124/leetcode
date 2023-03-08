package 数组;

import java.util.HashMap;
import java.util.Set;

/**
 * https://leetcode.cn/problems/majority-element/
 */
public class _169_多数元素 {
    //map 有一点赖
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                Integer value = map.get(nums[i]);
                map.put(nums[i], ++value);
            }
        }
        Set<Integer> set = map.keySet();
        int max = Integer.MIN_VALUE;
        int maxKey = -1;
        for (Integer key : set) {
            Integer v = map.get(key);
            if (v > max) {
                max = v;
                maxKey = key;
            }
        }
        return maxKey;
    }
}

