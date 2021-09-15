package 二叉树;

/**
 * https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class _1080_根到叶路径上的不足节点 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, limit, 0);
    }

    private TreeNode dfs(TreeNode root, int limit, int preSum) {
        if (root == null) return null;
        //递归前先记录一下当前节点是否是叶子节点
        boolean isLeaf = root.left == null && root.right == null;
        root.left = dfs(root.left, limit, preSum + root.val);
        root.right = dfs(root.right, limit, preSum + root.val);
        //回溯前进行判断
        //1、如果此节点本身就是叶子节点，并且总和 < limit 则要删除次节点
        if (isLeaf && preSum + root.val < limit) return null;
       /* 2、这个判断乍一看貌似很奇怪，什么情况会触发呢？
         原本不是叶子节点然而回溯回来的时候发现变成叶子节点了
         很多人卡在第111个测试用例就是因为这种情况的节点需要删除，
         所以我们之前记录了一下这个节点原来是不是叶子节点*/
        if (!isLeaf && root.left == null && root.right == null) return null;
        return root;
    }
}
