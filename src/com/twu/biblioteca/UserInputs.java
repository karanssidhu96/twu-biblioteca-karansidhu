package com.twu.biblioteca;

import java.util.Scanner;

public class UserInputs {

    public String menuUserInput(Scanner s)
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

    private boolean isMenuInputValid(String selectedMenuItem)
    {
        boolean result = ((selectedMenuItem.equals("List Books")||(selectedMenuItem.equals("Quit")))? true : false);
        return result;
    }
}
