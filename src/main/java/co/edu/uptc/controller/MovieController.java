package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Movie;
import co.edu.uptc.util.FilePersistence;

public class MovieController {

    private FilePersistence<Movie> filePersistence;
    private ArrayList<Movie> movies;

    public MovieController() {
        this.movies = new ArrayList<Movie>();
        filePersistence = new FilePersistence<Movie>();
    }

    public void readMovieFile(String fileName) {
        List<String[]> lines = filePersistence.readFile(fileName);
        if (lines == null) {
            return;
        }
        for (String[] strings : lines) {

            ArrayList<String> genres = new ArrayList<>();
            String[] genresData = strings[2].split("\\|");
            for (String genr : genresData) {
                genres.add(genr);
            }

            Movie movie = new Movie(Integer.parseInt(strings[0]), strings[1], genres);
            this.movies.add(movie);

        }
    }

    public Movie getMovieById(int id) {
        return this.movies.stream().filter(movie -> movie.getMovieId() == id).findFirst().orElse(null);
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }
}
