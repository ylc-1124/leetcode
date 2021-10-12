package 二叉树;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class _剑指Offer33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    /**
     * 验证数组中一部分是否满足二叉搜索树后序遍历，验证区间[begin,end]
     */
    private boolean verify(int[] postorder, int begin, int end) {
        //base case
        //如果验证区间不存在或者只有一个，肯定是满足的
        if (begin >= end) return true;
        //最右边一定是根节点的值
        int root = postorder[end];
        //找到右子树在数组中的起始索引
        int rIndex = begin;
        while (postorder[rIndex] < root) {
            rIndex++;
        }
        //右子树的值必须全部大于根节点
        for (int i = rIndex; i < end; i++) {
            if (postorder[i] < root) return false;
        }
        return verify(postorder, begin, rIndex - 1)
                && verify(postorder, rIndex, end - 1);
    }
}
