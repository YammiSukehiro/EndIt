package org.example;

public class Magazine extends Book {
    private int issueNumber;

    public Magazine(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return "[Magazine #" + issueNumber + "] " + super.toString();
    }
}

