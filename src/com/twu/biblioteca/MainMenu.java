package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {
    private Books books;
    public MainMenu(Books books)
    {
        this.books = books;
        menu();
    }

    private void menu()
    {
        System.out.println("Choose one of the following options");
        System.out.println("List Books");
        System.out.print("Your selection: ");
        String selectedMenuItem = userInput();
        innerMenu(selectedMenuItem);
    }

    private String userInput()
    {
        boolean inputValid;
        Scanner s = new Scanner(System.in);
        String selectedMenuItem = s.nextLine();
        inputValid = isInputValid(selectedMenuItem);
        while (!inputValid)
        {
            System.out.print("\r\nSelect a valid option!: ");
            selectedMenuItem = s.nextLine();
            inputValid = isInputValid(selectedMenuItem);
        }
        return selectedMenuItem;
    }

    private boolean isInputValid(String selectedMenuItem)
    {
        boolean result = (selectedMenuItem.equals("List Books") ? true : false);
        return result;
    }

    private void innerMenu(String selectedMenuItem)
    {
        switch (selectedMenuItem)
        {
            case "List Books":
                books.printListAllBooks();
                break;
            default:
                books.printListAllBooks();
                break;
        }
    }
}
