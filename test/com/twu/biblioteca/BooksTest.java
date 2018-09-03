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
    public void listBooksTest() {
        Books books = new Books();
        books.printListAllBooks();
        String expectedResult = "Frankenstein\r\nPride and Prejudice\r\nGreat Expectations\r\n";
        assertEquals(expectedResult, outContent.toString());
    }
}
