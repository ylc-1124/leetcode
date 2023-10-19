package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1726_同积元组 {
    public int tupleSameProduct(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                Integer freq = map.getOrDefault(product, 0);
                res += freq * 8;
                map.put(product, freq + 1);
            }
        }
        return res;
    }
}
