package 数学;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/25 9:58
 */
public class _2739_总行驶距离 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0; // 单位 10km
        while (mainTank > 0) {
            mainTank--;
            res++;
            if (res % 5 == 0 && additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }
        }
        return res * 10;
    }
}
