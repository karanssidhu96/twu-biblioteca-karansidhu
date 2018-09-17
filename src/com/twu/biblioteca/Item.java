package com.twu.biblioteca;

public abstract class Item {
    private boolean isItemCheckedOut;

    public boolean getIsItemCheckedOut() {
        return isItemCheckedOut;
    }

    public void setIsItemCheckedOut(boolean itemCheckedOut) {
        isItemCheckedOut = itemCheckedOut;
    }

    public void checkout(String itemType)
    {
        if (!this.isItemCheckedOut)
        {
            this.isItemCheckedOut = true;
            System.out.println(String.format("Thank you! Enjoy the %s", itemType));
        }
        else
        {
            System.out.println(String.format("That %s is not available", itemType));
        }
    }
}
