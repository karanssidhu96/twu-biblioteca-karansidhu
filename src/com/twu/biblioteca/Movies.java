package com.twu.biblioteca;

import java.util.ArrayList;

public class Movies {
    private ArrayList<Movie> allMovies = new ArrayList<Movie>();

    public Movies()
    {
        allMovies.add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9));
        allMovies.add(new Movie("Avengers: Infinity War", "Anthony Russo", 2018, 8));
        allMovies.add(new Movie("Three Billboards Outside Ebbing, Missouri", "Martin McDonagh",
                2017, 8));

    }
    public void printListOfAvailableMovies()
    {
        System.out.println(String.format("|%-50s|%-30s|%-30s|%-30s|", "Name", "Director", "Year", "Rating"));
        for (Movie movie : allMovies)
        {
            if (!movie.getIsItemCheckedOut())
            {
                System.out.println(String.format("|%-50s|%-30s|%-30s|%-30s|", movie.getName(), movie.getDirector(),
                        Integer.toString(movie.getYear()), Integer.toString(movie.getRating())));
            }
        }
    }

    public Movie findMovie(String movieName)
    {
        for (Movie movie : allMovies)
        {
            if (movie.getName().equals(movieName))
            {
                return movie;
            }
        }
        return null;
    }
}
