package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNo;
    private String password;
    private String name;
    private String email;
    private String phoneNo;

    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

    public User(String libraryNo, String password, String name, String email, String phoneNo)
    {
        this.libraryNo = libraryNo;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof User))
        {
            return false;
        }

        User user = (User) obj;

        return user.libraryNo.equals(libraryNo) && user.password.equals(password);
    }

    public void getDetails()
    {
        System.out.println(String.format("Your details\nName: %s\nE-Mail: %s\nPhone Number: %s", name, email, phoneNo));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + libraryNo.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
