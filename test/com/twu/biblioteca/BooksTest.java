package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BooksTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void checkoutTest()
    {
        Books books = new Books();
        books.findBook("Great Expectations").checkout();
        assertEquals(true, books.findBook("Great Expectations").getIsBookCheckedOut());
    }

    @Test
    public void listBooksInStockTest() {
        Books books = new Books();
        books.findBook("Great Expectations").checkout();
        books.printListAllBooksInStock();
        String expectedResult = String.format("|%-30s|%-30s|%-30s|\n|%-30s|%-30s|%-30s|" +
                        "\n|%-30s|%-30s|%-30s|\n", "Title", "Author", "Publication Year", "Frankenstein",
                        "Mary Shelley", "1818", "Pride and Prejudice", "Jane Austen", "1813");
        assertEquals(expectedResult, outContent.toString());
    }
}
