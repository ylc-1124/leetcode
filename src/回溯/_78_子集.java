package 回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class _78_子集 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int begin, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = begin; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            //撤销选择
            track.removeLast();
        }
    }
}
