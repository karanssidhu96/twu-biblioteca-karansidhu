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
        Movies movies = mock(Movies.class);
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Choose one of the following options\nList Books\nList Movies\nCheckout Book" +
                "\nCheckout Movie\nReturn Book\nQuit\nYour selection: " +
                "Choose one of the following options\nList Books\nList Movies\nCheckout Book" +
                "\nCheckout Movie\nReturn Book\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("List Books")
                .thenReturn("Quit");

        MainMenu menu = new MainMenu(books, movies, ui);
        assertEquals(expectedResult, outContent.toString());
        verify(books, times(1)).printListAllBooksInStock();
        verify(ui, times(2)).menuUserInput();
    }

    @Test
    public void mainMenuListMoviesTest() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Choose one of the following options\nList Books\nList Movies\nCheckout Book" +
                "\nCheckout Movie\nReturn Book\nQuit\nYour selection: " +
                "Choose one of the following options\nList Books\nList Movies\nCheckout Book\nCheckout Movie" +
                "\nReturn Book\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("List Movies")
                .thenReturn("Quit");

        MainMenu menu = new MainMenu(books, movies, ui);
        assertEquals(expectedResult, outContent.toString());
        verify(movies, times(1)).printListOfAvailableMovies();
        verify(ui, times(2)).menuUserInput();
    }

    @Test
    public void mainMenuCheckoutBookTest()
    {
        Books books = new Books();
        Movies movies = mock(Movies.class);
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Choose one of the following options\nList Books\nList Movies\nCheckout Book" +
                "\nCheckout Movie\nReturn Book\nQuit\nYour selection: " +
                "Which book would you like to checkout?: Thank you! Enjoy the book" +
                "\nChoose one of the following options\nList Books\nList Movies\nCheckout Book\nCheckout Movie" +
                "\nReturn Book\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("Checkout Book")
                .thenReturn("Quit");
        when(ui.bookTitleUserInput("That book is not available. Please choose another book or check spelling: "))
                .thenReturn("Pride and Prejudice");

        MainMenu menu = new MainMenu(books, movies, ui);
        assertEquals(expectedResult, outContent.toString());
        assertEquals(true, books.findBook("Pride and Prejudice").getIsItemCheckedOut());
    }

    @Test
    public void mainMenuCheckoutMovieTest()
    {
        Books books = new Books();
        Movies movies = new Movies();
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Choose one of the following options\nList Books\nList Movies\nCheckout Book" +
                "\nCheckout Movie\nReturn Book\nQuit\nYour selection: " +
                "Which movie would you like to checkout?: Thank you! Enjoy the movie" +
                "\nChoose one of the following options\nList Books\nList Movies\nCheckout Book\nCheckout Movie" +
                "\nReturn Book\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("Checkout Movie")
                .thenReturn("Quit");
        when(ui.movieNameUserInput())
                .thenReturn("The Shawshank Redemption");

        MainMenu menu = new MainMenu(books, movies, ui);
        assertEquals(expectedResult, outContent.toString());
        assertEquals(true, movies.findMovie("The Shawshank Redemption").getIsItemCheckedOut());
    }

    @Test
    public void mainMenuReturnBookTest()
    {
        Books books = new Books();
        Movies movies = mock(Movies.class);
        books.findBook("Pride and Prejudice").checkout("book");
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Thank you! Enjoy the book\nChoose one of the following options\nList Books" +
                "\nList Movies\nCheckout Book\nCheckout Movie\nReturn Book\nQuit\nYour selection: " +
                "Which book would you like to return?: Thank you for returning the book" +
                "\nChoose one of the following options\nList Books\nList Movies\nCheckout Book\nCheckout Movie" +
                "\nReturn Book\nQuit" +
                "\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("Return Book")
                .thenReturn("Quit");
        when(ui.bookTitleUserInput("That is not a valid book to return. " +
                "Please choose another book or check spelling: "))
                .thenReturn("Pride and Prejudice");

        MainMenu menu = new MainMenu(books, movies, ui);
        assertEquals(expectedResult, outContent.toString());
        assertEquals(false, books.findBook("Pride and Prejudice").getIsItemCheckedOut());
    }

    @Test
    public void mainMenuQuitTest()
    {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        UserInputs ui = mock(UserInputs.class);
        String expectedResult = "Choose one of the following options\nList Books\nList Movies\nCheckout Book" +
                "\nCheckout Movie\nReturn Book" +
                "\nQuit\nYour selection: ";
        when(ui.menuUserInput())
                .thenReturn("Quit");

        MainMenu menu = new MainMenu(books, movies, ui);
        assertEquals(expectedResult, outContent.toString());
        verify(ui, times(1)).menuUserInput();
    }
}
