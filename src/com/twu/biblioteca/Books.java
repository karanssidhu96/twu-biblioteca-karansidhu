package com.twu.biblioteca;

import java.util.Arrays;

public class Books {
    private Book[] allBooks = new Book[3];
    public Books()
    {
        allBooks[0] = new Book("Frankenstein");
        allBooks[1] = new Book("Pride and Prejudice");
        allBooks[2] = new Book("Great Expectations");
    }

    public void printListAllBooks()
    {
        for (Book book : allBooks)
        {
            System.out.println(book.getTitle());
        }
    }
}
