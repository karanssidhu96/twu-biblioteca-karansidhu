package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void checkoutMovie()
    {
        Movie movie = new Movie("A Movie", "A Person", 2018, 5);
        movie.checkout("movie");

        assertEquals(true, movie.getIsItemCheckedOut());
    }
}
