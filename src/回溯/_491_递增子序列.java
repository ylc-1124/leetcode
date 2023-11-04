package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _491_递增子序列 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();
        backtrack(nums, 0, selected, res);
        return res;
    }

    private void backtrack(int[] nums, int index,
                           List<Integer> selected,
                           List<List<Integer>> res) {
        // 存答案
        if (selected.size() >= 2) {
            res.add(new ArrayList<>(selected));
        }

        if (index >= nums.length) return;

        Set<Integer> set = new HashSet<>(); // 记录选择过的数字
        // 可选择的范围 nums[index...len-1]
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (!selected.isEmpty() && selected.get(selected.size() - 1) > nums[i]) continue;
            // 做选择
            selected.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, i + 1, selected, res);
            // 还原现场
            selected.remove(selected.size() - 1);
        }
    }
}
