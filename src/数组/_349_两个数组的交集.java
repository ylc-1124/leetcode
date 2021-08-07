package 数组;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();  //这里用 HashSet优于TreeSet
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        int[] res = getIntArray(set1, set2);
        return res;
    }

    private int[] getIntArray(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set3 = new HashSet<>();
        for (Integer data : set1) {
            if (set2.contains(data)) {
                set3.add(data);
            }
        }
        int[] arr = new int[set3.size()];
        int index = 0;
        for (Integer data : set3) {
            arr[index++] = data;
        }
        return arr;
    }
}
