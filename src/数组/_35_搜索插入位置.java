package 数组;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        int target = 7;
        int i = new _35_搜索插入位置().searchInsert(arr, target);
        System.out.println(i);
    }
}
