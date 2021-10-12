package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class _剑指Offer34_二叉树中和为某一值的路径 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target,new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int target,List<Integer> list) {
        if (root == null) return;
        //递归前把路径值放入列表中
        list.add(root.val);
        dfs(root.left, target - root.val,list);
        dfs(root.right, target - root.val, list);
        //回溯前判断
        if (root.left == null
                && root.right == null
                && target == root.val) {
            //注意一个小细节：我们一直用的同一个List对象在存放路径值
            res.add(new LinkedList<>(list));
        }
        //还原现场
        list.remove(list.size() - 1);
    }
}
