package leetcode周赛;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/12 11:15
 */
public class _100117_最大化数组末位元素的最少操作次数 {
    public int minOperations(int[] nums1, int[] nums2) {
        int ops = 0;
        int wei = nums1.length - 1; // 交换的位置
        // 保存副本
        int[] nums1_copy = new int[nums1.length];
        int[] nums2_copy = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1_copy[i] = nums1[i];
            nums2_copy[i] = nums2[i];
        }

        while (wei >= 0
                && (!moweiIsMax(nums1) || !moweiIsMax(nums2))) {
            int tmp = nums1[wei];
            nums1[wei] = nums2[wei];
            nums2[wei] = tmp;

            wei--;
        }

        int ops_1 = 0, ops_2 = 0;
        // 比较变化
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums1_copy[i]) ops_1++;
            if (nums1[i] != nums2_copy[i]) ops_2++;
        }
        ops = Math.min(ops_1, ops_2);

        if (wei < 0) { // 没有可以互换的位置了
            ops = -1;
        }
        return ops;
    }

    public static void main(String[] args) {
        System.out.println(new _100117_最大化数组末位元素的最少操作次数().minOperations(new int[]{1, 2, 7}, new int[]{4, 5, 3}));
    }

    // O(n)
    private boolean moweiIsMax(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] > num[num.length - 1]) return false;
        }
        return true;
    }
}
