package 二叉树;

public class _96_不同的二叉搜索树 {

    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    /**
     * 计算从[begin,end]区间内可以组成BST的数量
     */
    private int count(int begin, int end) {
        if (begin > end) return 1;
        if (memo[begin][end] != 0) return memo[begin][end];
        int res = 0;
        for (int i = begin; i <= end; i++) {
            int left = count(begin, i - 1);
            int right = count(i + 1, end);
            res += left * right;
        }
        memo[begin][end] = res;
        return res;
    }

}
