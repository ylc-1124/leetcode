package 每日一题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试用例
 * 00011
 * 01010
 * 00101
 * 11001
 * 00010
 * 01000
 *
 * # k=4
 * set={0,1}
 * res=1
 *
 * # k=3
 * set={00,01,11}
 * res=11
 *
 * # k=2
 * set={000,010,001,110}
 * res=111
 *
 * # k = 1
 * set={0001,0101,0010,1100,0001,0100}
 * res=1110
 *
 * # k = 0
 * set={00101,11001,00010,01000}
 * res=11100
 */
public class _421_数组中两个数的最大异或值 {

    // nums[i]取值范围在 0 ~ 2^31-1,
    // 因此只需要 31位即可表示所有元素, 最高位记为 30, 最低位记为 0
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        // 要找的最大值
        int res = 0;

        // 从最高位开始确定 res的值
        for (int k = HIGH_BIT; k >= 0; k--) {
            Set<Integer> set = new HashSet<>();

            // 将nums中所有元素的 [30..k]位, 放入set中
            for (int num : nums) {
                set.add(num >> k);
            }

            // 此时 res包含了 [30...k+1]位的部分, 我们要推测后面所有部分
            // 假设 res的第 k位能够取到 1
            int res_hypothesis = (res << 1) + 1;
            boolean found = false;

            for (int num : nums) {
                // 如果 set中有该元素, 则代表该位能够取 1
                if (set.contains(res_hypothesis ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                res = res_hypothesis;
            } else {
                res = res_hypothesis - 1;
            }

        }

        return res;
    }

//    // 超时
//    public int findMaximumXOR(int[] nums) {
//        if (nums.length == 1) return 0;
//        int n = nums.length;
//        Arrays.sort(nums);
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i <= n - 2; i++) {
//            max = Math.max(nums[n - 1] ^ nums[i], max);
//        }
//        return max;
//    }
}
