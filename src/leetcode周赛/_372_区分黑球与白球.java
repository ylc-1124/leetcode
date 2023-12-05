package leetcode周赛;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/19 10:51
 */
public class _372_区分黑球与白球 {
    public long minimumSteps(String s) {
        long res = 0L;
        char[] cs = s.toCharArray();
        int right = s.length() - 1;
        int memo = -999;
        while (right >= 0) {
            while (right >= 0 && cs[right] == '1') right--;
            // 找到离 right最近的 ‘1’
            int left = memo == -999 ? right - 1 : memo;
            while (left >= 0 && cs[left] == '0') left--;

            if (left >= 0) {
                // 累计移动步数
                res += (right - left);
                cs[left] = '0';
                cs[right] = '1';

                // 维护下次循环
                right--;
                memo = left - 1; // 下次从这里开始往前找 ‘1’
            } else {
                // 如果前面没有‘1’ 说明已经分类完成了
                break;
            }

        }

        return res;
    }

}
