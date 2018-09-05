package com.twu.biblioteca;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    public Books()
    {
        allBooks.add(new Book("Frankenstein", "Mary Shelley", 1818));
        allBooks.add(new Book("Pride and Prejudice", "Jane Austen", 1813));
        allBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
    }

    public void printListAllBooks()
    {
        System.out.println(String.format("|%-30s|%-30s|%-30s|", "Title", "Author", "Publication Year"));
        for (Book book : allBooks)
        {
            System.out.println(String.format("|%-30s|%-30s|%-30s|", book.getTitle(), book.getAuthor(),
                    Integer.toString(book.getPublicationYear())));
        }
    }
}
