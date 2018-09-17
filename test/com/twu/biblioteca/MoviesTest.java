package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MoviesTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void listAvailableMoviesTest() {
        Movies movies = new Movies();
        movies.printListOfAvailableMovies();
        String expectedResult = String.format("|%-30s|%-30s|%-30s|%-30|\n|%-30s|%-30s|%-30s|%-30|" +
                        "\n|%-30s|%-30s|%-30s|%-30|\n|%-30s|%-30s|%-30s|%-30|", "Name", "Director", "Year", "Rating",
                "The Shawshank Redemption", "Frank Darabont", "1994", "9",
                "Avengers: Infinity War", "Anthony Russo", "2018", "8",
                "Three Billboards Outside Ebbing, Missouri", "Martin McDonagh", "2017", "8");
        assertEquals(expectedResult, outContent.toString());
    }
}
