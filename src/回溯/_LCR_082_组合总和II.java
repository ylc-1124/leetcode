package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 组合 &有重 &不可复选
 * @author: ylc
 * @date: 2024/4/22 11:37
 */
public class _LCR_082_组合总和II {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, path, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int begin, List<Integer> path, int pathSum, int target) {
        if (pathSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (pathSum > target) return;

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            pathSum += candidates[i];
            backtrack(candidates, i + 1, path, pathSum, target);
            path.remove(path.size() - 1);
            pathSum -= candidates[i];
        }

    }
}
