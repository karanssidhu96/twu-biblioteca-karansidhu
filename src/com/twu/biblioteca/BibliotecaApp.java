package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca");
        Books books = new Books();
        Movies movies = new Movies();
        UserInputs ui = new UserInputs(books);
        MainMenu menu = new MainMenu(books, movies, ui);
    }
}
