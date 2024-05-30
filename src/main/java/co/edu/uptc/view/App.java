package co.edu.uptc.view;

import co.edu.uptc.controller.MovieController;
import co.edu.uptc.model.Movie;

public class App {
    public static void main(String[] args) {

        MovieController movieController = new MovieController();

        movieController.readMovieFile("movies");

        for (Movie movie : movieController.getMovies()) {
            System.out.println(movie.toString());
        }

    }
}
