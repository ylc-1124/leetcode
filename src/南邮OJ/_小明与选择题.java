package 南邮OJ;

import java.util.Scanner;

public class _小明与选择题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lens = new int[4];
        int all = 0;
        for (int i = 0; i < lens.length; i++) {
            lens[i] = sc.nextInt();
            all += lens[i];
        }
        int aver = all / 4; //平均长度

        //如果四个选项都一样长，则选择B选项；
        if (lens[0] == lens[1]
                && lens[1] == lens[2]
                && lens[2] == lens[3]) {
            printAnswer(1);
            return;
        }

        //区分长/短选项 true为长选项
        boolean[] len_flag = new boolean[4];
        int count_L = 0;
        for (int i = 0; i < lens.length; i++) {
            if (isLong(lens[i], aver)) {
                len_flag[i] = true;
                count_L++;
            }
        }
        //只要四个选项中有三个都是长选项，则选择最短的那个选项；
        if (count_L == 3) {
            for (int i = 0; i < len_flag.length; i++) {
                if (!len_flag[i]) {
                    printAnswer(i);
                    return;
                }
            }
        }
        //只要四个选项中有三个都是短选项，则选择最长的那个选项
        if (count_L == 1) {
            for (int i = 0; i < len_flag.length; i++) {
                if (len_flag[i]) {
                    printAnswer(i);
                    return;
                }
            }
        }

        //其他情况都是参差不齐情况，选择C选项
        printAnswer(2);

    }

    //判断长选项
    private static boolean isLong(int l, int aver) {
        if (l > aver) {
            return true;
        }
        return false;    //baobao
    }

    //根据下标输出选项
    private static void printAnswer(int index) {
        if (index == 0) {
            System.out.println("A");
        } else if (index == 1) {
            System.out.println("B");
        } else if (index == 2) {
            System.out.println("C");
        } else if (index == 3) {
            System.out.println("D");
        }
    }
}
