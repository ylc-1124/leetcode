package 每日一题;

public class _2582_递枕头 {
    public int passThePillow(int n, int time) {
        int m = time / (n - 1);
        // m为奇数则是在从右往左传的过程中结束的
        // m为偶数则是在从左往右的过程中结束的
        int remain = time - m * (n - 1); //剩余移动次数

        int res;
        if (m % 2 == 0) {
            res = 1 + remain;
        } else {
            res = n - remain;
        }

        return res;
    }
}
