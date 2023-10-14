package 每日一题;

public class _2591_把钱分给最多的儿童 {
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        else if (money < 8) return 0;
        int n = 0;
        while (8 * n <= money) {
            n++;
        }
        if (n > 0) n--;

        if (n > children) {
            n = children;
        }

        // 初始假设最多n个人分到8块, 剩余m块钱
        int m = money - 8 * n; // 剩余的钱
        int remain = children - n;  //几个没分到

        while ((remain == 1 && m == 4) // 不能等于4，拆个8
                || m < remain   // 不够一人一块也不行，得拆个8
                ||(remain == 0 && m > 0)) { // 都分到8了还有闲钱，不行
            n--;
            m = money - 8 * n;
            remain = children - n;
        }
        return n;
    }
}
