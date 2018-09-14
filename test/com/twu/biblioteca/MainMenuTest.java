package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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
        String expectedResult = "Choose one of the following options\nList Books\nQuit\nYour selection: " +
                "Choose one of the following options\nList Books\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("List Books")
                .thenReturn("Quit");

        MainMenu menu = new MainMenu(books, ui);
        assertEquals(expectedResult, outContent.toString());
        verify(books, times(1)).printListAllBooks();
        verify(ui, times(2)).menuUserInput();
    }

    @Test
    public void mainMenuQuitTest()
    {
        Books books = mock(Books.class);
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Choose one of the following options\nList Books\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("Quit");

        MainMenu menu = new MainMenu(books, ui);
        assertEquals(expectedResult, outContent.toString());
        verify(ui, times(1)).menuUserInput();
    }
}
