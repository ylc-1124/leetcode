package 数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] leftArray = new int[m];
        int[] rightArray = nums2;
        int li = 0, le = m;
        int ri = 0, re = n;
        int ai = 0; //指向nums1数组的起始位置
        //将nums1中的元素复制到leftArray中
        for (int i = 0; i < m; i++) {
            leftArray[i] = nums1[i];
        }
        while (li < le && ri < re) {
            if (leftArray[li] <= rightArray[ri]) {
                nums1[ai++] = leftArray[li++];
            } else {
                nums1[ai++] = rightArray[ri++];
            }
        }
        if (li < le) {  //右边空了左边没空
            for (int i = li; i < le; i++) {
                nums1[ai++] = leftArray[li++];
            }
        } else {  //左边空了，右边没空
            for (int i = ri; i < re; i++) {
                nums1[ai++] = rightArray[ri++];
            }
        }
    }
}
