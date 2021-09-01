package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class _95_不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
       return build(1, n);
    }

    /**
     * [begin,end]区间构造BST
     * @return 不同BST组合的根节点列表
     */
    private List<TreeNode> build(int begin, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (begin > end) {
            res.add(null);
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = build(begin, i - 1);
            List<TreeNode> right = build(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
