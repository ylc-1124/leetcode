package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class _40_组合总和II {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, 0, track, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int begin,
                           LinkedList<Integer> track, int target, int sum) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            track.add(candidates[i]);
            backtrack(candidates, i + 1,
                    track, target, sum + candidates[i]);
            track.removeLast();
        }
    }

}
