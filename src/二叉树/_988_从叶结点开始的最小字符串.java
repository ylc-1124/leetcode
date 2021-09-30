package 二叉树;

/**
 * https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
 */
public class _988_从叶结点开始的最小字符串 {
    String res;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        //将节点值(0~25)和'a'拼接一下,可以求得码表对应的字符
        char c = (char) ('a' + root.val);
        //递归前只需要做拼接
        sb.append(c);
        dfs(root.left, sb);
        dfs(root.right, sb);
        //回溯前需要比较,并还原现场
        if (root.left == null && root.right == null) {
            String str = sb.reverse().toString();
            //特别注意：这里必须再翻转一下当前的StringBuilder对象
            sb.reverse();
            if (res == null) {
                res = str;
            } else {
                //通过字符串比较大小的方式比较，res取小值的
                res = res.compareTo(str) > 0 ? str : res;
            }
        }
        //还原现场
        sb.deleteCharAt(sb.length() - 1);

    }
}
