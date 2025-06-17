package org.example;
import java.util.ArrayList;
import java.util.List;

public class Libary{
    private List<Book> books;
    private List<User> users;

    public Libary(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addUser(User user){
        users.add(user);
    }

    public Book findBook(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public User findUsers(String name){
        for (User user : users){
            if (user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public void rentBook(String title, String userName) {
        Book book = findBook(title);
        User user = findUsers(userName);


        if (book == null) {
            System.out.println("Книга \"" + title + "\" не найден");
            return;
        }
        if (user == null){
            System.out.println("Пользователь \"" + userName + "\" не найден" );
            return;
        }
        if (!book.isAvailable()){
            System.out.println("Книга уже в аренде");
            return;
        }

        book.setAvailable(false);
        user.rentBook(book);
        book.incrementRentCount();


        System.out.println(userName + "арендовал книгу: " + title);
    }
    public void returnBook(String title, String userName) {
        Book book = findBook(title);
        User user = findUsers(userName);

        if (book == null || user == null) {
            System.out.println("Ошибка возврата: книга или пользователь не найдены.");
            return;
        }

        if (!user.getRentedBooks().contains(book)) {
            System.out.println("У пользователя нет такой книги.");
            return;
        }

        book.setAvailable(true);
        user.returnBook(book);

        System.out.println(userName + " вернул книгу: " + title);
    }

    public void printStats() {
        System.out.println("Список книг в библиотеке:");
        for (Book book : books) {
            String status = book.isAvailable() ? "Доступна" : "Выдана";
            System.out.println("- " + book + " [" + status + "]");
        }

        System.out.println("\n👥 Пользователи и арендованные книги:");
        for (User user : users) {
            System.out.println("- " + user.getName());

            List<Book> rented = user.getRentedBooks();
            if (rented.isEmpty()) {
                System.out.println("  (нет арендованных книг)");
            } else {
                for (Book b : rented) {
                    System.out.println("  - " + b);
                }
            }
        }
    }
    public void findBooksByAuthor(String author) {
        System.out.println("Книги автора: " + author);
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("- " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ничего не найдено.");
        }
    }
    public void findBooksByType(Class<?> type) {
        System.out.println("Книги типа: " + type.getSimpleName());
        boolean found = false;
        for (Book book : books) {
            if (type.isInstance(book)) {
                System.out.println("- " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ничего не найдено.");
        }
    }

    public void removeBook(String title) {
        Book toRemove = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                toRemove = book;
                break;
            }
        }

        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("Книга \"" + title + "\" удалена из библиотеки.");
        } else {
            System.out.println("Книга \"" + title + "\" не найдена.");
        }
    }

    public void removeUser(String name) {
        User toRemove = null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                toRemove = user;
                break;
            }
        }

        if (toRemove != null) {
            users.remove(toRemove);
            System.out.println("Пользователь \"" + name + "\" удалён.");
        } else {
            System.out.println("Пользователь \"" + name + "\" не найден.");
        }
    }

    public void printPopularBooks() {
        System.out.println("Топ популярных книг по числу аренд:");

        books.stream()
                .sorted((b1, b2) -> Integer.compare(b2.getRentCount(), b1.getRentCount()))
                .forEach(book -> {
                    System.out.println("- " + book + " — взяли " + book.getRentCount() + " раз(а)");
                });
    }


}



