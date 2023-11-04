package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<Integer> selected = new ArrayList<>();

        backtrack(nums, used, selected, res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> selected, List<List<Integer>> res) {

        // 每个元素都选了，那么就添加到结果中
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 做选择
            selected.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, selected, res);
            // 还原现场
            used[i] = false;
            selected.remove(selected.size() - 1);
        }

    }

}

