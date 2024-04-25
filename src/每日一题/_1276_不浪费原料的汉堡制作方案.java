package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/25 21:24
 */
public class _1276_不浪费原料的汉堡制作方案 {
    // 设巨无霸 x个，小皇堡 y个  x+y=cheese   4x+2y=tomato
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        // 奇数个番茄不可能被用完
        if (tomatoSlices % 2 != 0) return res;
        for (int x = 0; x <= cheeseSlices; x++) {
            int y = cheeseSlices - x;
            if (4 * x + 2 * y == tomatoSlices) {
                res.add(x);
                res.add(y);
                return res;
            }

        }

        return res;
    }
}
