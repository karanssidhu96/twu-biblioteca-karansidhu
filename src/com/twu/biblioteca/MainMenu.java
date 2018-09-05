package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {
    public MainMenu(Books books)
    {
        menu(books);
    }

    private void menu(Books books)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose one of the following options");
        System.out.println("List Books");
        System.out.print("Your selection: ");
        String selectedMenuItem = s.nextLine();
        innerMenu(selectedMenuItem, books);
    }

    private void innerMenu(String selectedMenuItem, Books books)
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
