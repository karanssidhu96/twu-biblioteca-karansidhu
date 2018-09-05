package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca");
        Books books = new Books();
        MainMenu menu = new MainMenu(books);
    }
}
