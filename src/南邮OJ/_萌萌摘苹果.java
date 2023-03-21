package 南邮OJ;

import java.util.Scanner;

public class _萌萌摘苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //苹果总数
        int[] heights = new int[n]; //每个苹果到地面的高度
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        int h = sc.nextInt(); //伸手达到的最大高度
        int chair_height = 30; //板凳高度
        int count = 0; //记录摘下苹果的个数
        for (int i = 0; i < heights.length; i++) {
            if ((h + chair_height) >= heights[i]) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(count == n ? "Yes" : "No");
    }
}
