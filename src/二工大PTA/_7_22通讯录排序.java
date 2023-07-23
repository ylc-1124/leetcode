package 二工大PTA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _7_22通讯录排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        People[] peopleArr = new People[n];
        for (int i = 0; i < n; i++) {
            People p = new People();
            p.name = sc.next();
            p.birthday = sc.next();
            p.phone = sc.next();
            peopleArr[i] = p;
        }
        Arrays.sort(peopleArr, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.birthday.compareTo(o2.birthday);
            }
        });
        for (People p : peopleArr) {
            System.out.println(p);
        }

    }

    static class People {
        public String name;
        public String birthday;
        public String phone;

        @Override
        public String toString() {
            return name + " " + birthday + " " + phone;
        }
    }
}
