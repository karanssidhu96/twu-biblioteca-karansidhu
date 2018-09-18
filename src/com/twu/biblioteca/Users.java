package com.twu.biblioteca;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> allUsers = new ArrayList<User>();

    public Users()
    {
        allUsers.add(new User("007-1111","pass","Bob", "bob@bobmail.com",
                "01234567890"));
        allUsers.add(new User("007-2222","pass","Foo", "foo@foomail.com",
                "01234567891"));
        allUsers.add(new User("007-3333","pass","Bar", "bar@barmail.com",
                "01234567892"));
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public boolean logIn(User user)
    {
        return allUsers.contains(user);
    }
}
