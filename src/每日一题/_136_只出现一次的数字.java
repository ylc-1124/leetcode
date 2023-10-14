package 每日一题;

import java.util.*;

public class _136_只出现一次的数字 {
    //    一个数和它本身做异或运算结果为 0，即 a ^ a = 0；
    //    一个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a。
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }


//    public int singleNumber(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        Arrays.sort(nums);
//        // 如果num[i]与相邻的某一个元素相同，那么就不是答案
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                if (nums[i] != nums[i + 1]) {
//                    return nums[i];
//                }
//            } else if (i == nums.length - 1) {
//                if (nums[i] != nums[i - 1]) {
//                    return nums[i];
//                }
//            } else {
//                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
//                    return nums[i];
//                }
//            }
//        }
//        return -1;
//    }


//    public int singleNumber(int[] nums) {
//        // value是key出现的次数
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer times = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], times + 1);
//        }
//        for (Integer key : map.keySet()) {
//            if (map.get(key) == 1) return key;
//        }
//        return -1;
//    }
}
