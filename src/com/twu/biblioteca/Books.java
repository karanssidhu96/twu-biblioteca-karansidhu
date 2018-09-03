package com.twu.biblioteca;

public class Books {
    private Book[] allBooks = new Book[3];
    public Books()
    {
        allBooks[0] = new Book("Frankenstein", "Mary Shelley", 1818);
        allBooks[1] = new Book("Pride and Prejudice", "Jane Austen", 1813);
        allBooks[2] = new Book("Great Expectations", "Charles Dickens", 1861);
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
