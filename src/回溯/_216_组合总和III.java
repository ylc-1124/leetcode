package 回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class _216_组合总和III {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> track = new LinkedList<>();
        int[] candidate = new int[9];
        for (int i = 0; i < candidate.length; i++) {
            candidate[i] = i + 1;
        }
        backtrack(track, k, n,0,candidate,0);
        return res;
    }

    private void backtrack(List<Integer> track, int k, int n, int sum
            , int[] candidate, int index) {
        if (sum == n && track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i < candidate.length; i++) {
            //做选择
            track.add(candidate[i]);
            backtrack(track, k, n, sum + candidate[i], candidate, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
