package 二叉树;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/
 */
public class FindElements {
    private Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        rebuildTree(root, null);
    }

    private void rebuildTree(TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (parent == null) {
            root.val = 0;
        } else {
            root.val = root == parent.left ?
                    (parent.val << 1) + 1 : (parent.val << 1) + 2;
        }
        set.add(root.val);
        rebuildTree(root.left, root);
        rebuildTree(root.right, root);

    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
