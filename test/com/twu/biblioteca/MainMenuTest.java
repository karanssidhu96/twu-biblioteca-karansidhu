package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainMenuTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void mainMenuListBooksTest() {
        Books books = mock(Books.class);
        UserInputs ui = mock(UserInputs.class);
        String input = "List Books\r\nQuit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expectedResult = "Choose one of the following options\r\nList Books\r\nQuit\r\nYour selection: ";

        MainMenu menu = new MainMenu(books, ui);
        assertEquals(expectedResult, outContent.toString());
        verify(books, times(1)).printListAllBooks();
        verify(ui, times(2)).menuUserInput();
    }

    @Test
    public void mainMenuInvalidOptionTest()
    {
        Books books = mock(Books.class);
        UserInputs ui = mock(UserInputs.class);
        String input = "Not an Option\r\nList Books";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expectedResult = "Choose one of the following options\r\nList Books\r\nQuit\r\nYour selection: " +
                "\r\nSelect a valid option!: ";

        MainMenu menu = new MainMenu(books, ui);
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void mainMenuQuitTest()
    {
        Books books = mock(Books.class);
        UserInputs ui = mock(UserInputs.class);
        String input = "List Books\r\nQuit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expectedResult = "Choose one of the following options\r\nList Books\r\nQuit\r\nYour selection: ";

        MainMenu menu = new MainMenu(books, ui);
        assertEquals(expectedResult, outContent.toString());
    }
}
