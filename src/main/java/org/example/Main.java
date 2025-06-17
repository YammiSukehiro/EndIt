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

        System.out.println("\n===== Статистика библиотеки =====");
        lib.printStats();

        System.out.println("\n===== Поиск по автору =====");
        lib.findBooksByAuthor("Лев Толстой");

        System.out.println("\n===== Поиск по типу FictionBook =====");
        lib.findBooksByType(FictionBook.class);

        System.out.println("\n===== Поиск по типу Magazine =====");
        lib.findBooksByType(Magazine.class);

        System.out.println("\n===== Удаление книги =====");
        lib.removeBook("1984");

        System.out.println("\n===== Удаление пользователя =====");
        lib.removeUser("Лев");

        System.out.println("\n===== Статистика после удаления =====");
        lib.printStats();

        System.out.println("\n===== Топ популярных книг =====");
        lib.printPopularBooks();

    }
}