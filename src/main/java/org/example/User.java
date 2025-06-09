package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> rentedBooks;

    public User(String name, String rentedBooks) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void rentBook(Book book) {
        rentedBooks.add(book);
    }

    public void returnBook(Book book){
        rentedBooks.remove(book);
    }



    @Override
    public String toString() {
        return "User: " + name + ", Books: " + rentedBooks;
    }
}

