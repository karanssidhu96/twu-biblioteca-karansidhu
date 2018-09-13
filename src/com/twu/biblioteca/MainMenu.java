package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {
    private Books books;
    private UserInputs ui;
    public MainMenu(Books books, UserInputs ui)
    {
        this.books = books;
        this.ui = new UserInputs();
        menu();
    }

    private void menu()
    {
        String selectedMenuItem = "";
        Scanner s = new Scanner(System.in);
        do {
            displayMenu();
            selectedMenuItem = ui.menuUserInput(s);
            innerMenu(selectedMenuItem);
        } while (!selectedMenuItem.equals("Quit"));
    }

    private void displayMenu()
    {
        System.out.println("Choose one of the following options");
        System.out.println("List Books");
        System.out.println("Quit");
        System.out.print("Your selection: ");
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
