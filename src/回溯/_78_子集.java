package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class _78_子集 {

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        // 空集是任何集合的子集
        res.add(new ArrayList<>());
        // 路径
        List<Integer> path = new ArrayList<>();
        backtrack(path, nums, 0);
        return res;
    }

    private void backtrack(List<Integer> path, int[] nums, int idx) {
        if (idx >= nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            // 做选择
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            // 保证每次只能向后选择就不会出现重复子集
            backtrack(path, nums, i + 1);
            // 撤销选择
            path.remove(path.size() - 1);
        }

    }
//    List<List<Integer>> res = new LinkedList<>();
//    public List<List<Integer>> subsets(int[] nums) {
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(nums, 0, track);
//        return res;
//    }
//
//    private void backtrack(int[] nums, int begin, LinkedList<Integer> track) {
//        res.add(new LinkedList<>(track));
//        for (int i = begin; i < nums.length; i++) {
//            //做选择
//            track.add(nums[i]);
//            backtrack(nums, i + 1, track);
//            //撤销选择
//            track.removeLast();
//        }
//    }
}
