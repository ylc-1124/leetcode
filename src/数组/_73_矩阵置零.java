package 数组;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/
 */
public class _73_矩阵置零 {
    //    public void setZeroes(int[][] matrix) {
//        //标记要清0的行和列,rows[i]==1 代表i行要清0
//        int[] rows = new int[matrix.length];
//        int[] cols = new int[matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                //记录i行和j列要清0
//                if (matrix[i][j] == 0) {
//                    rows[i] = 1;
//                    cols[j] = 1;
//                }
//            }
//        }
//        //行清0
//        for (int i = 0; i < rows.length; i++) {
//            if (rows[i] == 1) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        //列清0
//        for (int i = 0; i < cols.length; i++) {
//            if (cols[i] == 1) {
//                for (int j = 0; j < matrix.length; j++) {
//                    matrix[j][i]=0;
//                }
//            }
//        }
//    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //标记i和j列需要清零
                    rows[i] = cols[j] = true;
                }
            }
        }
        //遍历二维数组，若元素所在行或列需要清零则清零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
