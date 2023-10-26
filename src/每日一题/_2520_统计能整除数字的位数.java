package 每日一题;

public class _2520_统计能整除数字的位数 {
    public int countDigits(int num) {
        int res = 0;
        int n = num;
        while (num != 0) {
            int digit = num % 10;
            if (n % digit == 0) res++;
            num /= 10;
        }
        return res;
    }
}
