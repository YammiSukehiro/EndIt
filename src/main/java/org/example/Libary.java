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
}


