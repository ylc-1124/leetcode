package 南邮OJ;

import java.util.*;

/**
 * 跟leetcode上合并区间是一样一样的
 */
public class _小明算树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 马路长度：若为500则有 0，1，2。。。500共计501课树
        int l = sc.nextInt();
        int m = sc.nextInt(); //区域数目
        int[][] area = new int[m][2];
        for (int i = 0; i < area.length; i++) {
            area[i][0] = sc.nextInt(); //起点
            area[i][1] = sc.nextInt(); //终点
        }
        //合并区间,将区间按起点升序排列
        Arrays.sort(area, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        //先放入起点最小的区间
        list.add(area[0]);
        for (int i = 1; i < area.length; i++) {
            int[] cur = area[i]; //当前遍历到的区间
            int[] last = list.get(list.size() - 1);
            if (cur[0] <= last[1]) {
                //合并区间
                last[1] = Math.max(cur[1], last[1]);
            } else {
                list.add(cur);
            }
        }
        //计算移除了多少树
        int count = 0;
        for (int[] arr : list) {
            count += ((arr[1] - arr[0]) + 1);
        }
        System.out.println((l + 1) - count);
    }
}
