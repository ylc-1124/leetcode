package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1333_餐厅过滤器 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly,
                                           int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(restaurants, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int[] restaurant : restaurants) {
            if (restaurant[2] >= veganFriendly // vf=1的话只有素食餐厅能满足该条件，vf=0的话任何餐厅都可以
                    && restaurant[3] <= maxPrice
                    && restaurant[4] <= maxDistance) {
                res.add(restaurant[0]);
            }
        }
        return res;

    }
//    public List<Integer> filterRestaurants(int[][] restaurants,
//                                           int veganFriendly,
//                                           int maxPrice,
//                                           int maxDistance) {
//
//        List<Integer> res = new ArrayList<>();
//        int len = restaurants.length; // 餐厅数量
//        if (veganFriendly == 1) {
//            //过滤出素食主义友好且满足条件的餐厅
//            for (int i = 0; i < len; i++) {
//                if (restaurants[i][2] == 0
//                        || restaurants[i][3] > maxPrice
//                        || restaurants[i][4] > maxDistance) {
//                    // 上移
//                    for (int row = i; row < len - 1; row++) {
//                        for (int col = 0; col < 5; col++) {
//                            restaurants[row][col] = restaurants[row + 1][col];
//                        }
//                    }
//                    len--;
//                    i--;
//                }
//            }
//        } else {
//            // 只需要过滤价格和距离不符合的餐厅
//            for (int i = 0; i < len; i++) {
//                if (restaurants[i][3] > maxPrice
//                        || restaurants[i][4] > maxDistance) {
//                    // 上移
//                    for (int row = i; row < len - 1; row++) {
//                        for (int col = 0; col < 5; col++) {
//                            restaurants[row][col] = restaurants[row + 1][col];
//                        }
//                    }
//                    len--;
//                    i--;
//                }
//            }
//        }
//        // 复制一份餐厅
//        int[][] restaurants_afterFilter = new int[len][5];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < 5; j++) {
//                restaurants_afterFilter[i][j] = restaurants[i][j];
//            }
//        }
//        Arrays.sort(restaurants_afterFilter, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] != o2[1]) {
//                    return o2[1] - o1[1];
//                } else {
//                    return o2[0] - o1[0];
//                }
//            }
//        });
//        for (int i = 0; i < len; i++) {
//            res.add(restaurants_afterFilter[i][0]);
//        }
//
//        return res;
//    }

}
