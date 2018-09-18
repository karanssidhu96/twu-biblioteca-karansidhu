package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UsersTest {
    @Test
    public void usersLogInTest()
    {
        Users users = new Users();
        User user1 = new User("007-1111", "pass");

        assertEquals(true, users.logIn(user1));
    }
}
