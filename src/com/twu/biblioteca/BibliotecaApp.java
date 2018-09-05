package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        Books books = new Books();
        MainMenu menu = new MainMenu(books);
    }
}
