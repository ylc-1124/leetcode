package 每日一题;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/23 12:01
 */
public class _1052_爱生气的书店老板 {

    public int maxSatisfied(int[] customers,
                            int[] grumpy,
                            int minutes) {

        // 计算不使用技巧能有多少用户满意
        int satisfied_customers = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                satisfied_customers += customers[i];
            }
        }

        // 初始化窗口内的值
        int delta = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                delta += customers[i];
            }
        }

        // 滑动窗口 开滑
        int max_delta = delta;
        for (int i = minutes; i < grumpy.length; i++) {
            // 模拟将下标 i的窗口移入，将最前面的窗口移出
            if (grumpy[i - minutes] == 1) {
                delta -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                delta += customers[i];
            }
            // 将滑动完的结果进行比较，找个所有窗口中值最大的
            max_delta = Math.max(max_delta, delta);
        }

        return satisfied_customers + max_delta;
    }
//    // 超时
//    private int res = 0;
//    public int maxSatisfied(int[] customers,
//                            int[] grumpy,
//                            int minutes) {
//
//        for (int begin = 0, end = begin + minutes - 1; end < grumpy.length; begin++, end++) {
//            // 穷举出老板所有可能保持微笑的时间，比较出哪段时间满意顾客最多
//            int satisfied_customers = 0;
//            for (int i = 0; i < grumpy.length; i++) {
//                if (i >= begin && i <= end) {
//                    satisfied_customers += customers[i];
//                } else {
//                    // 老板微笑，顾客才满意
//                    if (grumpy[i] == 0) {
//                        satisfied_customers += customers[i];
//                    }
//                }
//            }
//            res = Math.max(satisfied_customers, res);
//        }
//
//        return res;
//    }
}
