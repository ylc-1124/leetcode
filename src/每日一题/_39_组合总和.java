package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 子集问题 & 无重可复选
 * @author: ylc
 * @date: 2024/4/20 10:38
 */
public class _39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 已做出的选择
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, 0, 0, path, target);
        return res;
    }

    private void backtrack(int[] candidates, int begin, int pathSum
            , List<Integer> path, int target) {
        if (pathSum > target) return;

        if (pathSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 可做哪些选择
        for (int i = begin; i < candidates.length; i++) {
            // 做选择
            path.add(candidates[i]);
            pathSum += candidates[i];
            backtrack(candidates, i, pathSum, path, target);
            // 撤销选择
            path.remove(path.size() - 1);
            pathSum -= candidates[i];
        }
    }
}
