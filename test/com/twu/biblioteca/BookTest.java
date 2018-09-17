package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void successfulCheckoutBookTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.checkout();
        String expectedOutput = "Thank you! Enjoy the book\n";

        assertEquals(true, book.getIsBookCheckedOut());
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void unsuccessfulCheckoutBookAlreadyCheckedOutTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.checkout();
        book.checkout();
        String expectedOutput = "Thank you! Enjoy the book\nThat book is not available\n";

        assertEquals(true, book.getIsBookCheckedOut());
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void returnBookTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.checkout();
        book.returnBook();

        assertEquals(false, book.getIsBookCheckedOut());
    }
}
