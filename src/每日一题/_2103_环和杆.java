package 每日一题;

public class _2103_环和杆 {
    public int countPoints(String rings) {
        // gan[i][0]代表 i号杆的红色圈数量
        // gan[i][1]代表 i号杆的绿色圈数量
        // gan[i][2]代表 i号杆的蓝色圈数量
        int[][] gan = new int[10][3];
        int count = 0;
        for (int i = 0; i <= rings.length() - 2; i += 2) {
            int j = Integer.parseInt(rings.charAt(i + 1) + "");
            if (rings.charAt(i) == 'R') {
                gan[j][0] += 1;
            } else if (rings.charAt(i) == 'G') {
                gan[j][1] += 1;
            } else if (rings.charAt(i) == 'B') {
                gan[j][2] += 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (gan[i][0] > 0 && gan[i][1] > 0 && gan[i][2] > 0) {
                count++;
            }
        }
        return count;
    }
}
