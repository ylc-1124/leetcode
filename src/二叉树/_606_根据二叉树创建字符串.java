package 二叉树;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
public class _606_根据二叉树创建字符串 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    /**
     * 遍历以root为根节点的树，将树形结构按照要求写到传入的StringBuilder对象中
     */
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        //1、左子树不为空则遍历左子树，按要求写到sb中
        if (root.left != null) {
            sb.append('(');
            dfs(root.left, sb);
            sb.append(')');
        } else if (root.right != null) {
            //执行到这说明左子树为空，右子树不为空，需要写直接写()
            sb.append('(').append(')');
        }
        //2、右子树不为空，按要求把右子树结构写到sb中，这里不用管右子树为空，因为可以省略
        if (root.right != null) {
            sb.append('(');
            dfs(root.right, sb);
            sb.append(')');
        }
    }
}
