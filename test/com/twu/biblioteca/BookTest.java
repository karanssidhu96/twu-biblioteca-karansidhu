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
        book.checkout("book");
        String expectedOutput = "Thank you! Enjoy the book\n";

        assertEquals(true, book.getIsItemCheckedOut());
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void unsuccessfulCheckoutBookAlreadyCheckedOutTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.checkout("book");
        book.checkout("book");
        String expectedOutput = "Thank you! Enjoy the book\nThat book is not available\n";

        assertEquals(true, book.getIsItemCheckedOut());
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void successfulReturnBookTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.checkout("book");
        book.returnBook();
        String expectedOutput = "Thank you! Enjoy the book\nThank you for returning the book\n";

        assertEquals(false, book.getIsItemCheckedOut());
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void unsuccessfulReturnBookNotCheckedOutTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.returnBook();
        String expectedOutput = "That is not a valid book to return\n";

        assertEquals(false, book.getIsItemCheckedOut());
        assertEquals(expectedOutput, outContent.toString());
    }
}
