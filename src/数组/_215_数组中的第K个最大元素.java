package 数组;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
