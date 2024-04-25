package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/20 11:03
 */
public class _LCR_079_子集 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int begin, List<Integer> track) {
        res.add(new ArrayList<>(track));

        // 可做选择的范围 nums[begin]....nums[end]
        for (int i = begin; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}
