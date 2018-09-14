package com.twu.biblioteca;

public class MainMenu {
    private Books books;
    private UserInputs ui;
    public MainMenu(Books books, UserInputs ui)
    {
        this.books = books;
        this.ui = ui;
        runMenu();
    }

    private void runMenu()
    {
        String selectedMenuItem;
        do {
            selectedMenuItem = menu();
        } while (!selectedMenuItem.equals("Quit"));
    }

    private String menu()
    {
        displayMenu();
        String selectedMenuItem = ui.menuUserInput();
        innerMenu(selectedMenuItem);
        return selectedMenuItem;
    }

    private void displayMenu()
    {
        System.out.println("Choose one of the following options");
        System.out.println("List Books");
        System.out.println("Checkout Book");
        System.out.println("Quit");
        System.out.print("Your selection: ");
    }

    private void checkoutBook()
    {
        System.out.println("\nWhich book would you like to checkout?: ");
        String bookToCheckoutTitle = ui.bookNameUserInput();
        books.findBook(bookToCheckoutTitle).checkout();
    }

    private void innerMenu(String selectedMenuItem)
    {
        switch (selectedMenuItem)
        {
            case "List Books":
                books.printListAllBooksInStock();
                break;
            case "Checkout Book":
                checkoutBook();
                break;
            case "Quit":
                break;
            default:
                books.printListAllBooksInStock();
                break;
        }
    }
}
