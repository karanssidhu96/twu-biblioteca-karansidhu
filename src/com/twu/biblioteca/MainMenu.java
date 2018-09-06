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
        String selectedMenuItem = "";
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Choose one of the following options");
            System.out.println("List Books");
            System.out.println("Quit");
            System.out.print("Your selection: ");
            selectedMenuItem = userInput(s);
            innerMenu(selectedMenuItem);
        } while (!selectedMenuItem.equals("Quit"));
    }

    private String userInput(Scanner s)
    {
        boolean inputValid;
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
        boolean result = ((selectedMenuItem.equals("List Books")||(selectedMenuItem.equals("Quit")))? true : false);
        return result;
    }

    private void innerMenu(String selectedMenuItem)
    {
        switch (selectedMenuItem)
        {
            case "List Books":
                books.printListAllBooks();
                break;
            case "Quit":
                System.exit(0);
            default:
                books.printListAllBooks();
                break;
        }
    }
}
