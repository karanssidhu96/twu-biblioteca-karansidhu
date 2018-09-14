package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void checkoutBookTest()
    {
        Book book = new Book("Book", "Mr Book", 2018);
        book.checkout();

        assertEquals(true, book.getCheckedOutBook());
    }
}
