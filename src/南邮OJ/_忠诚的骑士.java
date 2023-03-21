package 南邮OJ;

import java.util.Scanner;

public class _忠诚的骑士 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); //要给骑士发放k天工资
        int coins = 0; //收到的金币总数
        int salary = 1; //当前日薪
        int times = 0; //当前日薪发放的天数
        //工作k天，发放k天工资
        for (int i = 0; i < k; i++) {
            coins += salary; //收到一天工资
            times++; //次数+1
            if (times == salary) {
                times = 0;
                salary++;
            }
        }
        System.out.println(coins);
    }
}
