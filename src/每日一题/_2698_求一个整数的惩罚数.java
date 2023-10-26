package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class _2698_求一个整数的惩罚数 {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isPunishNum(i)) {
                res += i * i;
            }
        }
        return res;
    }

    private boolean isPunishNum(int i) {
        int n = i * i;
        String candidates = String.valueOf(n);
        List<String> selectedStr = new ArrayList<>();
        // 判断 n是否是惩罚数
        return backtrack(candidates, 0, selectedStr, i);
    }

    private boolean backtrack(String candidates, int index,
                              List<String> selectedStr, int dest) {
        if (index == candidates.length()) {
            int sum = 0;
            for (String s : selectedStr) {
                int num = Integer.parseInt(s);
                sum += num;
            }
            // 当前分割方式满足要求，所以candidates是惩罚数
            return sum == dest;
        }

        for (int i = index; i < candidates.length(); i++) {
            // 每次将 candidates[index..j]的子串作为选择
            selectedStr.add(candidates.substring(index, i + 1));
            if (backtrack(candidates, i + 1, selectedStr, dest)) {
                return true;
            }
            // 还原现场
            selectedStr.remove(selectedStr.size() - 1);
        }

        return false;
    }


}
