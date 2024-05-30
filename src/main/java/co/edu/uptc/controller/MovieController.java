package co.edu.uptc.controller;

import java.util.ArrayList;

import co.edu.uptc.model.Genr;
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
        String[] lines = filePersistence.readFile(fileName);

        if (lines != null) {
            for (String line : lines) {
                String[] movieData = line.split(",");
                if (movieData.length == 3) {
                    ArrayList<Genr> genrs = new ArrayList<>();
                    String[] genrData = movieData[2].split("\\|");
                    for (String genr : genrData) {
                        Genr newGenr = new Genr(genr);
                        genrs.add(newGenr);
                    }

                    Movie movie = new Movie(Integer.parseInt(movieData[0]), movieData[1], genrs);
                    this.movies.add(movie);
                }
            }
        }
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

}
