package ccf;

/**
 * @description:
 * @author: ylc
 * @date: 2024/2/1 16:28
 */
public class c_多项式还原 {
    public static void main(String[] args) {
        // 已知的值
        double n = 10.0; // x = 1 时的结果
        double m = 484540.0; // x = n + 1 时的结果

        // 多项式的次数
        int k = 5; // 假设为二次多项式

        // 构建系数矩阵
        double[][] coefficients = new double[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            coefficients[0][i] = 1;
            coefficients[1][i] = Math.pow(n + 1, i);
        }

        // 构建常数矩阵
        double[] constants = new double[k + 1];
        constants[0] = n;
        constants[1] = m;

        // 解线性方程组
        double[] solution = solveLinearSystem(coefficients, constants);

        // 打印解
        System.out.println("Solution:");
        for (int i = 0; i <= k; i++) {
            System.out.println("a" + i + " = " + solution[i]);
        }
    }

    // 解线性方程组的方法
    private static double[] solveLinearSystem(double[][] coefficients, double[] constants) {
        int size = coefficients.length;

        // 高斯消元法
        for (int i = 0; i < size; i++) {
            // 将当前列的第i个元素缩放为1
            double scale = coefficients[i][i];
            for (int j = 0; j < size; j++) {
                coefficients[i][j] /= scale;
            }
            constants[i] /= scale;

            // 将其他行的第i个元素消为0
            for (int k = 0; k < size; k++) {
                if (k != i) {
                    double factor = coefficients[k][i];
                    for (int j = 0; j < size; j++) {
                        coefficients[k][j] -= factor * coefficients[i][j];
                    }
                    constants[k] -= factor * constants[i];
                }
            }
        }

        return constants;
    }
}
