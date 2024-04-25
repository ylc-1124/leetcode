package 回溯;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, path);

        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            // 做选择
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, path);
            // 撤销选择
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int n = nums.length;
//        boolean[] used = new boolean[n];
//        List<Integer> selected = new ArrayList<>();
//
//        backtrack(nums, used, selected, res);
//        return res;
//    }
//
//    private void backtrack(int[] nums, boolean[] used,
//                           List<Integer> selected, List<List<Integer>> res) {
//
//        // 每个元素都选了，那么就添加到结果中
//        if (selected.size() == nums.length) {
//            res.add(new ArrayList<>(selected));
//            return;
//        }
//
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i]) continue;
//            if (set.contains(nums[i])) continue;
//            // 做选择
//            selected.add(nums[i]);
//            set.add(nums[i]);
//            used[i] = true;
//            backtrack(nums, used, selected, res);
//            // 还原现场
//            used[i] = false;
//            selected.remove(selected.size() - 1);
//        }
//
//    }

//    List<List<Integer>> res = new LinkedList<>();
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        LinkedList<Integer> track = new LinkedList<>();
//        //used数组记录对应的nums列表中的值是否使用
//        boolean[] used = new boolean[nums.length];
//        Arrays.fill(used, false);
//        Arrays.sort(nums); // TODO: 2021/10/16
//        backtrack(nums, track, used);
//
//        return res;
//    }
//
//    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
//        if (track.size() == nums.length) {
//            res.add(new LinkedList<>(track));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            //剪枝
//            if (used[i] == true) continue;
//            if (i > 0 && nums[i] == nums[i - 1]
//                    && used[i - 1] == true) continue;
//            track.add(nums[i]);
//            used[i] = true;
//            backtrack(nums, track, used);
//            used[i] = false;
//            track.removeLast();
//        }
//    }
}
