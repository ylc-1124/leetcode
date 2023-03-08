package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * https://leetcode.cn/problems/single-number/
 */
public class _136_只出现一次的数字 {
    //赖皮解法
//    public int singleNumber(int[] nums) {
//        //保存元素与出现次数的映射
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int result = -999;
//        for (int i = 0; i < nums.length; i++) {
//            int key = nums[i];
//            if (map.containsKey(key)) {
//                Integer times = map.get(key);
//                map.put(key, ++times);
//            } else {
//                map.put(key, 1);
//            }
//        }
//        //遍历map
//        Set<Integer> keys = map.keySet();
//        for (Integer key : keys) {
//            if (map.get(key) == 1) {
//                result = key;
//                break;
//            }
//        }
//        return result;
//    }
    public int singleNumber(int[] nums) { //O(n)
        if (nums.length == 1) return nums[0];
        int res = 0;
        Arrays.sort(nums);
        //除第一个元素和最后一个元素外，其余元素都有前趋和后继
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
        }
        //单独处理首元素和尾元素
        if (nums[0] != nums[1]) {
            //首元素不等于第二个元素，说明它就是要找的元素
            res = nums[0];
        } else if (nums[nums.length - 1] != nums[nums.length - 2]) {
            //尾元素不等于前一个元素，则它就是要找的元素
            res = nums[nums.length - 1];
        }
        return res;
    }
}
