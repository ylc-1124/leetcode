package 二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
public class _652_寻找重复的子树 {

    //保存每棵树序列化后的样子与出现次数的映射关系
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    /**
     * 序列化一棵树，并查看是否出现过
     */
    private String serialize(TreeNode root) {
        if (root == null) return "#";
        String s = serialize(root.left) + ","
                + serialize(root.right) + ","
                + root.val;
        Integer freq = map.getOrDefault(s, 0);
        if (freq == 1) {
            //已经出现过一次则加入结果集
            res.add(root);
        }
        map.put(s, freq + 1);

        return s;
    }
//    Map<String, Integer> memo = new HashMap<>();
//    List<TreeNode> ans = new LinkedList<>();
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        serialize(root);
//        return ans;
//    }
//
//    /**
//     * 将以root为根节点的树进行序列化
//     */
//    private String serialize(TreeNode root) {
//        if (root == null) return "#";
//
//        /*将左右子树序列化*/
//        String left = serialize(root.left);
//        String right = serialize(root.right);
//
//        String subTree = left + "," + right + "," + root.val;
//        /*查看子树出现的次数*/
//        int freq = memo.getOrDefault(subTree, 0);
//        /*出现次数 == 1 则将其加入结果列表*/
//        if (freq == 1) {
//            ans.add(root);
//        }
//        memo.put(subTree, ++freq);
//        return subTree;
//    }
}
