package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Clean date", 200);
        Book book3 = new Book("Clean made", 300);
        Book book4 = new Book("Clean code", 400);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Поменяли местами книги с индексом 0 и 3:");
        books[0] = book4;
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Выводим книги с нужным именем:");
        String nameBook = "Clean code";
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals(nameBook)) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }

}