package 回溯;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class _79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (search(board, word, row, col, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word,
                           int row, int col, int i, boolean[][] visited) {
        //base case
        if (i >= word.length()) return true;
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(i)
                || visited[row][col]) return false;

        //做选择
        visited[row][col] = true;
        boolean result = search(board, word, row + 1, col, i + 1, visited)
                || search(board, word, row - 1, col, i + 1, visited)
                || search(board, word, row, col + 1, i + 1, visited)
                || search(board, word, row, col - 1, i + 1, visited);
        //撤销选择
        visited[row][col] = false;
        return result;
    }

}
