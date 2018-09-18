package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void userEqualityTest()
    {
        User user1 = new User("007-1111","pass","Bob", "bob@bobmail.com",
                "0123456789");
        User user2 = new User("007-1111","pass","Bob", "bob@bobmail.com",
                "0123456789");

        assertEquals(true, user1.equals(user2));
        assertEquals(true, user1.hashCode() == user2.hashCode());
    }

    @Test
    public void userDetailsTest()
    {
        User user1 = new User("007-1111","pass","Bob", "bob@bobmail.com",
                "0123456789");

        String expectedResult = "Your details\nName: Bob\nE-Mail: bob@bobmail.com\nPhone Number: 0123456789\n";

        user1.getDetails();
        assertEquals(expectedResult, outContent.toString());
    }
}
