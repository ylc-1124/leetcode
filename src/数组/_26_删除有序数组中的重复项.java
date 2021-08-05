package 数组;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums==null) return 0;
        int n;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            n=nums[i-1];
            if (nums[i] != n) {
                nums[++j] = nums[i];

            }

        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 4, 4, 5};
        int i = new _26_删除有序数组中的重复项().removeDuplicates(arr);
        System.out.println(i);

    }
}
