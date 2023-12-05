package leetcode周赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/19 11:54
 */
public class _372_找到Alice和Bob可以相遇的建筑 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        Map<Query, Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            // 重复的查询直接写答案
            Query query = new Query(a, b);
            // 备忘录有 直接用
            if (map.containsKey(query)) {
                Integer res = map.get(query);
                ans[i] = res;
                continue;
            }

            // 两者在同一建筑的情况
            if (a == b) {
                ans[i] = a;
                map.put(query, a);
                continue;
            }

            // 判断小的一方能否到大的一方
            int min = a > b ? b : a;
            int max = a > b ? a : b;
            int hmin = heights[min];
            int hmax = heights[max];
            if (hmin < hmax) {
                ans[i] = max;
                map.put(query, max);
                continue;
            }

            // 其余情况
            int ha = heights[a];
            int hb = heights[b];
            boolean flag = false;
            for (int j = Math.max(a, b) + 1; j < heights.length; j++) {
                if (heights[j] > ha && heights[j] > hb) {
                    ans[i] = j;
                    map.put(query, j);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans[i] = -1;
                map.put(query, -1);
            }
        }

        return ans;
    }

    static class Query{
        public int a;
        public int b;

        public Query(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Query query = (Query) o;
            return a == query.a && b == query.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
