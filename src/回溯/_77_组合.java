package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class _77_组合 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        backtrack(1, n, k, track);
        return res;
    }

    private void backtrack(int begin, int end, int k, List<Integer> track) {
        if (track.size() > k) return;
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = begin; i <= end; i++) {
            track.add(i);
            backtrack(i + 1, end, k, track);
            track.remove(track.size() - 1);
        }
    }


//    List<List<Integer>> res = new LinkedList<>();
//
//    public List<List<Integer>> combine(int n, int k) {
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(1, track, k, n);
//        return res;
//    }
//
//    private void backtrack(int start, LinkedList<Integer> track, int k, int n) {
//        if (track.size() == k) {
//            res.add(new LinkedList<>(track));
//            return;
//        }
//        for (int i = start; i <= n; i++) {
//            //做选择
//            track.add(i);
//            backtrack(i + 1, track, k, n);
//            //撤销选择
//            track.removeLast();
//        }
//    }
}
