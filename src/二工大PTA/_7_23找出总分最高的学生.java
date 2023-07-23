package 二工大PTA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _7_23找出总分最高的学生 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            Student stu = new Student();
            stu.number = sc.next();
            stu.name = sc.next();
            stu.score1 = sc.nextInt();
            stu.score2 = sc.nextInt();
            stu.score3 = sc.nextInt();
            stu.sum = stu.score1 + stu.score2 + stu.score3;
            students[i] = stu;
        }
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.sum - o1.sum;
            }
        });
        System.out.println(students[0]);
    }

    static class Student {
        public String number;

        public String name;
        public int score1;
        public int score2;
        public int score3;

        public int sum;

        @Override
        public String toString() {
            return name + " " + number + " " + sum;
        }
    }

}
