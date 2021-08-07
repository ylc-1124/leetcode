package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class _33_搜索旋转排序数组 {
    // 方法一：调用java的api赖皮解法
 /*   public int search(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        if (list.contains(target)) return list.indexOf(target);
        return -1;
    }*/
    //方法二： 二分查找
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n==0) return -1;
        if (n==1) return nums[0] == target ? 0 : -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target==nums[mid]) return mid;
            if (nums[0] <= nums[mid]) {  //左边有序就在左边进行二分查找
                if (target < nums[mid] && target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

}
