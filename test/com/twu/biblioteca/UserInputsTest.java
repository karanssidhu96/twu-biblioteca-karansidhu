package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserInputsTest {

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void userSelectsListBooksTest()
    {
        Books books = new Books();
        String input = "List Books";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInputs ui = new UserInputs(books);
        assertEquals(ui.menuUserInput(), "List Books");
    }

    @Test
    public void userSelectsQuitTest()
    {
        Books books = new Books();
        String input = "Quit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInputs ui = new UserInputs(books);
        assertEquals(ui.menuUserInput(), "Quit");
    }

    @Test
    public void userSelectsCheckoutBookTest()
    {
        Books books = new Books();
        String input = "Checkout Book";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInputs ui = new UserInputs(books);
        assertEquals(ui.menuUserInput(), "Checkout Book");
    }

    @Test
    public void userBookTitleInputTest()
    {
        Books books = new Books();
        String input = "Great Expectations";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInputs ui = new UserInputs(books);
        assertEquals(ui.bookTitleUserInput(), "Great Expectations");
    }

    @Test
    public void userSelectsInvalidBookTitleThenValidBookTitleTest()
    {
        Books books = new Books();
        String input = "Not a Book\nGreat Expectations";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expectedResult = "That book is not available. Please choose another book or check spelling: ";

        UserInputs ui = new UserInputs(books);
        assertEquals(ui.bookTitleUserInput(), "Great Expectations");
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void userSelectsInvalidThenValidInputQuitTest()
    {
        Books books = new Books();
        String input = "Invalid input\nQuit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expectedResult = "\r\nSelect a valid option!: ";

        UserInputs ui = new UserInputs(books);
        assertEquals(ui.menuUserInput(), "Quit");
        assertEquals(expectedResult, outContent.toString());
    }
}
