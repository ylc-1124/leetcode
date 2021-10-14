package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class _39_组合总和 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(track, 0, candidates, target,0);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int sum,
                           int[] candidates, int target,int index) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if (sum + candidates[i] > target) break;
            //做选择
            track.add(candidates[i]);
            backtrack(track, sum + candidates[i],
                    candidates, target, i);
            //撤销选择
            track.removeLast();
        }

    }
}
