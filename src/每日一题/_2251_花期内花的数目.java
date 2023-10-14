package 每日一题;

import java.util.Arrays;

public class _2251_花期内花的数目 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        int[] starts = new int[flowers.length];
        int[] ends = new int[flowers.length];

        // 花期中花的数量 = 开花数 - 凋零数
        for (int i = 0; i < flowers.length; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        // 开花数（starts中 <= arrive_time）  凋零数 (ends中 < arrive_time)
        for (int i = 0; i < people.length; i++) {
            res[i] = binary_search(starts, people[i] + 1)  // 注意此处 + 1
                    - binary_search(ends, people[i]);
        }

        return res;
    }

    /**
     * 返回第一个 >= x 的下标
     */
    public int binary_search(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
//    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//        int[] res = new int[people.length];
//        // 按开花的起始时间递增排序
//        Arrays.sort(flowers,(o1, o2) -> o1[0] - o2[0]);
//        for (int i = 0; i < people.length; i++) {
//            int arrive_time = people[i];
//            int open_flowers = 0;
//            for (int j = 0; j < flowers.length; j++) {
//                // 判断当前游客到达的时间，在几个花的花期内
//                int start = flowers[j][0];
//                int end = flowers[j][1];
//                // 如果到达的时间比当前花早，那么后面花肯定也没开，不用看了
//                if (arrive_time < start) break;
//                // 在花期内，累计数量
//                if (arrive_time <= end) open_flowers++;
//            }
//            res[i] = open_flowers;
//        }
//        return res;
//    }
}
