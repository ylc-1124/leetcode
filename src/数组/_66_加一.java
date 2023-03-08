package 数组;

/**
 * https://leetcode.cn/problems/plus-one/
 */
public class _66_加一 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            //没有进位则结束
            if (digits[i] != 0) return digits;
        }
        //每一位都进位了
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
