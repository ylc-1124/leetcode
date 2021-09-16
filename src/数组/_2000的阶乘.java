package 数组;

public class _2000的阶乘 {
    public static void main(String[] args) {
        int n = 2000;
        int size = 1; //res的位数
        int[] res = new int[6000]; //按位存放结果
        //base case
        res[0] = 1;
        for (int val = 2; val <= n; val++) {
            int carry = 0;
            /*val乘以res数组的每一位*/
            for (int pos = 0; pos < size; pos++) {
                int tmp = res[pos] * val + carry;
                res[pos] = tmp % 10;
                carry = tmp / 10; //剩下的给下一位用
            }
            while (carry != 0) {
                res[size++] = carry % 10; //维护size的值
                carry /= 10;
            }
        }
        //打印结果
        for (int pos = size - 1; pos >= 0; pos--) {
            System.out.print(res[pos]);
        }
    }
}
