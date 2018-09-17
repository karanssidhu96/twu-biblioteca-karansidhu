package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isMovieCheckedOut;

    public Movie(String name, String director, int year, int rating)
    {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isMovieCheckedOut = false;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public boolean getIsMovieCheckedOut() {
        return isMovieCheckedOut;
    }

    public void checkout()
    {

    }
}
