package 每日一题;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/12 9:50
 */
public class _2454_下一个更大元素IV {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (o1, o2) -> o2[0] - o1[0]);
        // 保存比当前元素大的所有元素下标
        TreeSet<Integer> ts = new TreeSet<>();
        for (int[] pair : pairs) {
            int idx = pair[1];
            Integer j = ts.higher(idx);
            if (j != null && ts.higher(j) != null) {
                ans[idx] = nums[ts.higher(j)];
            }
            ts.add(idx);
        }

        return ans;
    }


//    public int[] secondGreaterElement(int[] nums) {
//        int n = nums.length;
//        int[] answer = new int[n];
//        // 记录没有第一大的元素
//        Set<Integer> set = new HashSet<>();
//
//        // 最后两个元素没有第二大元素
//        for (int i = n - 1; i >= n - 2 && i >= 0; i--) {
//            answer[i] = -1;
//        }
//        for (int i = 0; i <= n - 3; i++) {
//            int cur = nums[i];
//            // 如果之前找过当前元素，连第一大都没有，那么肯定没第二大
//            if (set.contains(cur)) {
//                answer[i] = -1;
//                continue;
//            }
//
//            // 往后面找cur的第二大
//            int idx = i + 1;
//            // 找到第一大
//            while (idx < n && nums[idx] <= cur) idx++;
//            if (idx < n) {
//                // 找到了第一大，开始找第二大
//                idx++;
//                while (idx < n && nums[idx] <= cur) idx++;
//                if (idx < n) {
//                    answer[i] = nums[idx];
//                } else {
//                    answer[i] = -1;
//                }
//            } else {
//                // 第一大都没有，肯定没有第二大
//                answer[i] = -1;
//                set.add(cur);
//            }
//        }
//
//        return answer;
//    }
}
