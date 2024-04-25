package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class _40_组合总和II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        int pathSum = 0;
        Arrays.sort(candidates);
        backtrack(candidates, 0, path, pathSum, target);
        return res;
    }

    private void backtrack(int[] candidates, int start,
                           List<Integer> path, int pathSum, int target) {
        if (pathSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (pathSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 有重不可复选求子集的剪枝操作
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            // 做选择
            path.add(candidates[i]);
            pathSum += candidates[i];
            backtrack(candidates, i + 1, path, pathSum, target);
            // 撤销选择
            path.remove(path.size() - 1);
            pathSum -= candidates[i];
        }
    }


//    List<List<Integer>> res = new LinkedList<>();
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(candidates, 0, track, target, 0);
//        return res;
//    }
//
//    private void backtrack(int[] candidates, int begin,
//                           LinkedList<Integer> track, int target, int sum) {
//        if (sum == target) {
//            res.add(new LinkedList<>(track));
//            return;
//        }
//        for (int i = begin; i < candidates.length; i++) {
//            if (sum + candidates[i] > target) break;
//            if (i > begin && candidates[i] == candidates[i - 1]) continue;
//            track.add(candidates[i]);
//            backtrack(candidates, i + 1,
//                    track, target, sum + candidates[i]);
//            track.removeLast();
//        }
//    }

}
