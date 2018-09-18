package com.twu.biblioteca;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> allUsers = new ArrayList<User>();

    public Users()
    {
        allUsers.add(new User("007-1111","pass"));
        allUsers.add(new User("007-2222","pass"));
        allUsers.add(new User("007-3333","pass"));
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public boolean logIn(User user)
    {
        return allUsers.contains(user);
    }
}
