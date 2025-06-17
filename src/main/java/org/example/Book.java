package org.example;


public class Book {
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    @Override
    public String toString(){
        return "\"" + title + "\" by " + author;
    }

    private boolean isAvailable = true;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    private int rentCount = 0;

    public int getRentCount() {
        return rentCount;
    }

    public void incrementRentCount() {
        rentCount++;
    }


}

