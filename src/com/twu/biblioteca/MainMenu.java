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
        Scanner s = new Scanner(System.in);
        String selectedMenuItem = s.nextLine();
        if (!selectedMenuItem.equals("List Books"))
        {
            while (!selectedMenuItem.equals("List Books"))
            {
                System.out.print("\r\nSelect a valid option!: ");
                selectedMenuItem = s.nextLine();
            }
        }
        return selectedMenuItem;
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
