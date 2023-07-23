package 二工大PTA;

import java.util.Scanner;

public class _7_7通讯录的录入与显示 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            Person p = new Person();
            p.name = sc.next();
            p.birthday = sc.next();
            p.gender = sc.next();
            p.guhua = sc.next();
            p.phone = sc.next();
            persons[i] = p;
        }
        int k = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            if (arr[i] >= persons.length || arr[i] < 0) {
                System.out.println("Not Found");
            } else {
                Person p = persons[arr[i]];
                System.out.printf("%s %s %s %s %s\n", p.name, p.guhua, p.phone, p.gender, p.birthday);
            }
        }

    }

    static class Person {
        public String name;
        public String birthday;
        public String gender;
        public String guhua;
        public String phone;
    }
}
