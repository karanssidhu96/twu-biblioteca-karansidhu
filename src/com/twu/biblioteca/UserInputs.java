package com.twu.biblioteca;

import java.util.Scanner;

public class UserInputs {

    private Books books;

    UserInputs(Books books)
    {
        this.books = books;
    }

    private Scanner s = new Scanner(System.in);
    public String menuUserInput()
    {
        boolean inputValid;
        String selectedMenuItem = s.nextLine();
        inputValid = isMenuInputValid(selectedMenuItem);
        while (!inputValid)
        {
            System.out.print("\r\nSelect a valid option!: ");
            selectedMenuItem = s.nextLine();
            inputValid = isMenuInputValid(selectedMenuItem);
        }
        return selectedMenuItem;
    }

    public String bookTitleUserInput()
    {
        boolean inputValid;
        String bookTitle = s.nextLine();
        inputValid = isBookTitleValid(bookTitle);
        while (!inputValid)
        {
            System.out.print("That book is not available. Please choose another book or check spelling: ");
            bookTitle = s.nextLine();
            inputValid = isBookTitleValid(bookTitle);
        }
        return bookTitle;
    }

    private boolean isMenuInputValid(String selectedMenuItem)
    {
        boolean result = ((selectedMenuItem.equals("List Books")||(selectedMenuItem.equals("Quit"))
                ||(selectedMenuItem.equals("Checkout Book")))? true : false);
        return result;
    }

    private boolean isBookTitleValid(String bookTitle)
    {
        for (Book book : books.getAllBooks())
        {
            if (book.getTitle().equals(bookTitle))
            {
                return true;
            }
        }
        return false;
    }
}
