package com.twu.biblioteca;

public class MainMenu {
    private Books books;
    private UserInputs ui;
    private Movies movies;
    private Users users;
    public MainMenu(Books books, Movies movies, UserInputs ui, Users users)
    {
        this.books = books;
        this.ui = ui;
        this.movies = movies;
        this.users = users;
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
        System.out.println("List Movies");
        System.out.println("Checkout Book");
        System.out.println("Checkout Movie");
        System.out.println("Return Book");
        System.out.println("Get Details");
        System.out.println("Quit");
        System.out.print("Your selection: ");
    }

    private void checkoutBook()
    {
        User user = logIn();
        if (user != null)
        {
            System.out.print("Which book would you like to checkout?: ");
            String bookToCheckoutTitle = ui.bookTitleUserInput("That book is not available. " +
                    "Please choose another book or check spelling: ");
            Book book = books.findBook(bookToCheckoutTitle);
            book.checkout("book");
            users.getAllUsers().get(users.getAllUsers().indexOf(user)).getCheckedOutBooks().add(book);
        }
        else {System.out.println("Authentication failed, unable to log in");}
    }

    private void checkoutMovie()
    {
        System.out.print("Which movie would you like to checkout?: ");
        String movieToCheckoutTitle = ui.basicUserInput();
        movies.findMovie(movieToCheckoutTitle).checkout("movie");
    }

    private void returnBook()
    {
        User user = logIn();
        if (user != null)
        {
            System.out.print("Which book would you like to return?: ");
            String bookToReturnTitle = ui.bookTitleUserInput("That is not a valid book to return. " +
                    "Please choose another book or check spelling: ");
            Book book = books.findBook(bookToReturnTitle);
            book.returnBook();
            users.getAllUsers().get(users.getAllUsers().indexOf(user)).getCheckedOutBooks().remove(book);
        }
        else {System.out.println("Authentication failed, unable to log in");}
    }

    private void getDetails()
    {
        User user = logIn();
        if (user != null)
        {
            users.getAllUsers().get(users.getAllUsers().indexOf(user)).getDetails();
        }
        else {System.out.println("Authentication failed, unable to log in");}
    }

    private User logIn()
    {
        System.out.print("You must log in to access this service\nLibrary Number: ");
        String libraryNo = ui.basicUserInput();
        System.out.print("Password: ");
        String password = ui.basicUserInput();
        User user = new User(libraryNo, password,"","","");
        if (users.logIn(user))
        {
            return user;
        }
        else return null;
    }

    private void innerMenu(String selectedMenuItem)
    {
        switch (selectedMenuItem)
        {
            case "List Books":
                books.printListAllBooksInStock();
                break;
            case "List Movies":
                movies.printListOfAvailableMovies();
                break;
            case "Checkout Book":
                checkoutBook();
                break;
            case "Checkout Movie":
                checkoutMovie();
                break;
            case "Return Book":
                returnBook();
                break;
            case "Get Details":
                getDetails();
                break;
            case "Quit":
                break;
            default:
                books.printListAllBooksInStock();
                break;
        }
    }
}
