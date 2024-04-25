package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题 &无重 &不可复选
 */
public class _216_组合总和III {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        backtrack(1, path, 0, k, n);
        return res;
    }

    private void backtrack(int begin, List<Integer> path, int pathSum, int k, int n) {
        if (path.size() == k && pathSum == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() > k) return;

        for (int i = begin; i <= 9; i++) {
            path.add(i);
            pathSum += i;
            backtrack(i + 1, path, pathSum, k, n);
            path.remove(path.size() - 1);
            pathSum -= i;
        }
    }

//    List<List<Integer>> res = new LinkedList<>();
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        List<Integer> track = new LinkedList<>();
//        int[] candidate = new int[9];
//        for (int i = 0; i < candidate.length; i++) {
//            candidate[i] = i + 1;
//        }
//        backtrack(track, k, n,0,candidate,0);
//        return res;
//    }
//
//    private void backtrack(List<Integer> track, int k, int n, int sum
//            , int[] candidate, int index) {
//        if (sum == n && track.size() == k) {
//            res.add(new LinkedList<>(track));
//            return;
//        }
//        for (int i = index; i < candidate.length; i++) {
//            //做选择
//            track.add(candidate[i]);
//            backtrack(track, k, n, sum + candidate[i], candidate, i + 1);
//            track.remove(track.size() - 1);
//        }
//    }
}
