package 回溯;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class _90_子集II {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int begin, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));


        for (int i = begin; i < nums.length; i++) {
            // 剪枝，确保不会添加重复的元素
            if (i > begin && nums[i] == nums[i - 1]) continue;
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }
}
