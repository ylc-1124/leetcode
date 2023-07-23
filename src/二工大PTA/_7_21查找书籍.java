package 二工大PTA;

import java.util.Scanner;

public class _7_21查找书籍 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Book[] books = new Book[n];
        int max_index = -1, min_index = -1;
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            sc.nextLine(); // 接收 nextInt结束的回车符
            book.name = sc.nextLine();
            book.price = sc.nextDouble();
            books[i] = book;
            if (min_index == -1 && max_index == -1) {
                min_index = i;
                max_index = i;
            }
            if (book.price > books[max_index].price) {
                max_index = i;
            }
            if (book.price < books[min_index].price) {
                min_index = i;
            }
        }
        System.out.printf("%.2f, %s\n", books[max_index].price, books[max_index].name);
        System.out.printf("%.2f, %s\n", books[min_index].price, books[min_index].name);
    }

    static class Book {
        public String name;
        public double price;
    }
}
