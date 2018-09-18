package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void userEqualityTest()
    {
        User user1 = new User("007-1111","pass");
        User user2 = new User("007-1111","pass");

        assertEquals(true, user1.equals(user2));
        assertEquals(true, user1.hashCode() == user2.hashCode());
    }

}
