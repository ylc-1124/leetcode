package 二叉树;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int maxValue = Integer.MIN_VALUE, index = -1;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, begin, index - 1);
        root.right = build(nums, index + 1, end);

        return root;
    }
}
