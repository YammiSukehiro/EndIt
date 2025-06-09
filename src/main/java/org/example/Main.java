package org.example;


public class Main {
    public static void main(String[] args) {
        Libary lib = new Libary();

        Book book1 = new Book("1984", "Джордж Оруэлл");
        Book book2 = new Book("Преступление и наказание", "Фёдор Достоевский");

        User user1 = new User("Лев", "Толстой");

        lib.addBook(book1);
        lib.addBook(book2);
        lib.addUser(user1);

        lib.rentBook("1984", "Лев");
        lib.rentBook("1984", "Лев");
        lib.returnBook("1984", "Лев");
        lib.returnBook("1984", "Лев");

        Book fictionBook = new FictionBook("Война и мир", "Лев Толстой");
        Book magazine = new Magazine("National Geographic", "Various Authors", 2023);

        lib.addBook(fictionBook);
        lib.addBook(magazine);

    }
}