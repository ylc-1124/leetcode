package 二叉树;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     * 在[begin,end]范围建树
     */
    private TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = buildTree(nums, begin, maxIndex - 1);
        node.right = buildTree(nums, maxIndex + 1, end);
        return node;
    }

//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums == null || nums.length == 0) return null;
//
//        return build(nums, 0, nums.length - 1);
//    }
//
//    private TreeNode build(int[] nums, int begin, int end) {
//        if (begin > end) return null;
//        int maxValue = Integer.MIN_VALUE, index = -1;
//        for (int i = begin; i <= end; i++) {
//            if (nums[i] > maxValue) {
//                maxValue = nums[i];
//                index = i;
//            }
//        }
//        TreeNode root = new TreeNode(maxValue);
//        root.left = build(nums, begin, index - 1);
//        root.right = build(nums, index + 1, end);
//
//        return root;
//    }
}
