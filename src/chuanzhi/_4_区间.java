package chuanzhi;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/17 18:16
 */
public class _4_区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] cmds = new String[n];
        for (int i = 0; i < n; i++) {
            cmds[i] = sc.nextLine();
        }


    }

    static class QJ {
        int start;
        int end;

        public boolean XiaoJiao(QJ qj) {
            return this.end > qj.start || (this.start > qj.start && this.end < qj.end)
                    || qj.end < this.start || (qj.start > this.start && qj.end < this.end);
        }
    }
}
