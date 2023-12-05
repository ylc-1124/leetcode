package 数学;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/12 9:44
 */
public class _69_x的平方根 {
    public int mySqrt(int x) {
        return binary_search(x);
    }

    private int binary_search(int x) {
        if (x <= 1) return x;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new _69_x的平方根().mySqrt(2147395599));
    }
}
