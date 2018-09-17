package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private boolean isBookCheckedOut;

    public Book(String title, String author, int publicationYear)
    {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isBookCheckedOut = false;
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

    public Boolean getIsBookCheckedOut() { return isBookCheckedOut; }

    public void checkout()
    {
        if (!this.isBookCheckedOut)
        {
            this.isBookCheckedOut = true;
            System.out.println("Thank you! Enjoy the book");
        }
        else
        {
            System.out.println("That book is not available");
        }
    }

    public void returnBook()
    {

    }
}
