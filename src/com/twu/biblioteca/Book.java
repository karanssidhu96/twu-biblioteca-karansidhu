package com.twu.biblioteca;

public class Book extends Item {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear)
    {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.setIsItemCheckedOut(false);
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

    public void returnBook()
    {
        if (this.getIsItemCheckedOut())
        {
            this.setIsItemCheckedOut(false);
            System.out.println("Thank you for returning the book");
        }
        else
        {
            System.out.println("That is not a valid book to return");
        }

    }
}
