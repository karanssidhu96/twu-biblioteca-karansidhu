package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private boolean checkedOutBook;

    public Book(String title, String author, int publicationYear)
    {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.checkedOutBook = false;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCheckedOutBook() { return checkedOutBook; }

    public void checkout()
    {
        this.checkedOutBook = true;
    }
}
