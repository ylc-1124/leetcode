package 二叉树;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if (begin > end) return null;
        /*造根节点*/
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        TreeNode left = sortedArrayToBST(nums, begin, mid - 1);
        TreeNode right = sortedArrayToBST(nums, mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}
