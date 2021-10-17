package 回溯;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        //used数组记录对应的nums列表中的值是否使用
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums); // TODO: 2021/10/16
        backtrack(nums, track, used);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (used[i] == true) continue;
            if (i > 0 && nums[i] == nums[i - 1]
                    && used[i - 1] == true) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            used[i] = false;
            track.removeLast();
        }
    }
}
